package com.onlinepayments.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * {@link Marshaller} implementation based on {@link Gson}.
 */
public class DefaultMarshaller implements Marshaller {

    // Gson instances are thread-safe, so reuse one single instance
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter().nullSafe())
            .create();

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public static final DefaultMarshaller INSTANCE = new DefaultMarshaller();

    protected DefaultMarshaller() {
    }

    @Override
    public String marshal(Object requestObject) {
        return GSON.toJson(requestObject);
    }

    @Override
    public <T> T unmarshal(String responseJson, Class<T> type) {
        try {
            return GSON.fromJson(responseJson, type);
        } catch (JsonSyntaxException e) {
            throw new MarshallerSyntaxException(e);
        }
    }

    @Override
    public <T> T unmarshal(InputStream responseJson, Class<T> type) {
        try {
            return GSON.fromJson(new InputStreamReader(responseJson, CHARSET), type);
        } catch (JsonSyntaxException e) {
            throw new MarshallerSyntaxException(e);
        }
    }

    private static final class LocalDateAdapter extends TypeAdapter<LocalDate> {

        @Override
        @SuppressWarnings("resource")
        public void write(JsonWriter out, LocalDate value) throws IOException {
            out.value(value.format(DateTimeFormatter.ISO_DATE));
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            return LocalDate.parse(in.nextString(), DateTimeFormatter.ISO_DATE);
        }
    }

    private static final class ZonedDateTimeAdapter extends TypeAdapter<ZonedDateTime> {

        @Override
        @SuppressWarnings("resource")
        public void write(JsonWriter out, ZonedDateTime value) throws IOException {
            out.value(value.truncatedTo(ChronoUnit.MILLIS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        }

        @Override
        public ZonedDateTime read(JsonReader in) throws IOException {
            return ZonedDateTime.parse(in.nextString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
    }
}
