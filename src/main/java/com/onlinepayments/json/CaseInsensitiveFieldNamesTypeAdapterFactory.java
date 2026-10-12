package com.onlinepayments.json;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Lets domain objects be deserialized when a JSON key differs from the field's JSON name only in casing.
 * <p>
 * JSON names are determined the same way Gson determines them: inherited fields are included, static, transient and
 * synthetic fields are skipped, and {@link SerializedName} (including its alternates) takes precedence over the
 * {@link FieldNamingStrategy}. Keys that match a JSON name exactly are used as-is. Keys that match the names of two
 * different fields case-insensitively are left alone. Serialization is not affected.
 */
final class CaseInsensitiveFieldNamesTypeAdapterFactory implements TypeAdapterFactory {

    private static final String DOMAIN_PACKAGE = "com.onlinepayments.domain";

    private final String packagePrefix;

    CaseInsensitiveFieldNamesTypeAdapterFactory() {
        this(DOMAIN_PACKAGE);
    }

    CaseInsensitiveFieldNamesTypeAdapterFactory(String packageName) {
        this.packagePrefix = packageName + ".";
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (rawType.isEnum() || !rawType.getName().startsWith(packagePrefix)) {
            return null;
        }

        JsonNames names = JsonNames.of(rawType, gson.fieldNamingStrategy());
        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        TypeAdapter<JsonElement> jsonAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            @Override
            public T read(JsonReader in) throws IOException {
                JsonElement json = jsonAdapter.read(in);
                if (json.isJsonObject()) {
                    names.renameKeys(json.getAsJsonObject());
                }
                return delegate.fromJsonTree(json);
            }
        };
    }

    private static final class JsonNames {

        private final Set<String> exactNames = new HashSet<>();

        private final Map<String, List<String>> fieldNamesByLowerCase = new HashMap<>();

        static JsonNames of(Class<?> type, FieldNamingStrategy namingStrategy) {
            JsonNames names = new JsonNames();
            for (Class<?> current = type; current != null && current != Object.class; current = current.getSuperclass()) {
                for (Field field : current.getDeclaredFields()) {
                    if (isSerializable(field)) {
                        names.add(field, namingStrategy);
                    }
                }
            }
            return names;
        }

        private static boolean isSerializable(Field field) {
            int modifiers = field.getModifiers();
            return !Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && !field.isSynthetic();
        }

        private void add(Field field, FieldNamingStrategy namingStrategy) {
            List<String> fieldNames = new ArrayList<>();
            SerializedName annotation = field.getAnnotation(SerializedName.class);
            if (annotation != null) {
                fieldNames.add(annotation.value());
                fieldNames.addAll(Arrays.asList(annotation.alternate()));
            } else {
                fieldNames.add(namingStrategy.translateName(field));
            }

            for (String name : fieldNames) {
                exactNames.add(name);
                String lowerCase = name.toLowerCase(Locale.ROOT);
                if (!fieldNamesByLowerCase.containsKey(lowerCase)) {
                    fieldNamesByLowerCase.put(lowerCase, fieldNames);
                } else if (fieldNamesByLowerCase.get(lowerCase) != fieldNames) {
                    fieldNamesByLowerCase.put(lowerCase, null);
                }
            }
        }

        void renameKeys(JsonObject json) {
            for (String key : new ArrayList<>(json.keySet())) {
                if (exactNames.contains(key)) {
                    continue;
                }
                List<String> fieldNames = fieldNamesByLowerCase.get(key.toLowerCase(Locale.ROOT));
                if (fieldNames != null && fieldNames.stream().noneMatch(json::has)) {
                    json.add(fieldNames.get(0), json.remove(key));
                }
            }
        }
    }
}
