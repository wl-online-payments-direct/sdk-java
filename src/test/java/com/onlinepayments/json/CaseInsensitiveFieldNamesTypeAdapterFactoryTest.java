package com.onlinepayments.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

class CaseInsensitiveFieldNamesTypeAdapterFactoryTest {

    private static final String MODEL_PACKAGE = "com.onlinepayments.json";

    private final Gson gson = createGson(MODEL_PACKAGE);

    @Nested
    @DisplayName("When deserializing")
    class WhenDeserializing {

        @Test
        @DisplayName("a key that differs only in casing is bound to the field")
        void keyWithDifferentCasingIsBound() {
            Person camelCase = gson.fromJson("{\"firstName\":\"Jane\",\"lastName\":\"Doe\"}", Person.class);
            Person upperCase = gson.fromJson("{\"FIRSTNAME\":\"Jane\",\"LASTNAME\":\"Doe\"}", Person.class);

            assertEquals("Jane", camelCase.firstName);
            assertEquals("Doe", camelCase.lastName);
            assertEquals("Jane", upperCase.firstName);
            assertEquals("Doe", upperCase.lastName);
        }

        @Test
        @DisplayName("a key that matches the JSON name exactly is still bound")
        void exactKeyIsBound() {
            Person result = gson.fromJson("{\"FirstName\":\"Jane\"}", Person.class);

            assertEquals("Jane", result.firstName);
        }

        @Test
        @DisplayName("an exact match takes precedence over a case-insensitive match")
        void exactMatchTakesPrecedence() {
            Person result = gson.fromJson("{\"firstName\":\"case-insensitive\",\"FirstName\":\"exact\"}", Person.class);

            assertEquals("exact", result.firstName);
        }

        @Test
        @DisplayName("nested objects and lists of objects are handled")
        void nestedObjectsAndListsAreHandled() {
            Order result = gson.fromJson("{"
                    + "\"orderId\":\"o-1\","
                    + "\"customer\":{\"firstName\":\"Jane\"},"
                    + "\"lines\":[{\"product\":\"pen\",\"quantity\":2},{\"PRODUCT\":\"ink\",\"Quantity\":1}]"
                    + "}", Order.class);

            assertEquals("o-1", result.orderId);
            assertEquals("Jane", result.customer.firstName);
            assertEquals(2, result.lines.size());
            assertEquals("pen", result.lines.get(0).product);
            assertEquals(Integer.valueOf(2), result.lines.get(0).quantity);
            assertEquals("ink", result.lines.get(1).product);
            assertEquals(Integer.valueOf(1), result.lines.get(1).quantity);
        }

        @Test
        @DisplayName("enum values are deserialized as before")
        void enumValuesAreDeserialized() {
            OrderLine result = gson.fromJson("{\"product\":\"pen\",\"status\":\"SHIPPED\"}", OrderLine.class);

            assertEquals(Status.SHIPPED, result.status);
        }

        @Test
        @DisplayName("unknown keys and null values are ignored as before")
        void unknownKeysAndNullsAreIgnored() {
            Order result = gson.fromJson("{\"orderId\":\"o-1\",\"somethingNew\":{\"a\":1},\"customer\":null}", Order.class);

            assertEquals("o-1", result.orderId);
            assertNull(result.customer);
        }

        @Test
        @DisplayName("a JSON null is deserialized as null")
        void jsonNullIsNull() {
            assertNull(gson.fromJson("null", Person.class));
        }

        @Test
        @DisplayName("types outside the configured package are not affected")
        void typesOutsidePackageAreNotAffected() {
            Gson otherPackage = createGson("com.example.other");

            Person result = otherPackage.fromJson("{\"firstName\":\"Jane\"}", Person.class);

            assertNull(result.firstName);
        }
    }

    @Nested
    @DisplayName("When serializing")
    class WhenSerializing {

        @Test
        @DisplayName("JSON names are written unchanged")
        void jsonNamesAreUnchanged() {
            Person person = new Person();
            person.firstName = "Jane";

            String json = gson.toJson(person);

            assertEquals("{\"FirstName\":\"Jane\"}", json);
        }
    }

    @Nested
    @DisplayName("With inheritance")
    class WithInheritance {

        @Test
        @DisplayName("inherited fields are matched case-insensitively")
        void inheritedFieldsAreMatched() {
            Employee result = gson.fromJson("{\"firstName\":\"Jane\",\"employeeNumber\":\"e-1\"}", Employee.class);

            assertEquals("Jane", result.firstName);
            assertEquals("e-1", result.employeeNumber);
        }
    }

    @Nested
    @DisplayName("With excluded fields")
    class WithExcludedFields {

        @Test
        @DisplayName("static and transient fields are not bound")
        void staticAndTransientFieldsAreNotBound() {
            CachedValue result = gson.fromJson(
                    "{\"defaultValue\":\"changed\",\"cachedValue\":\"changed\",\"value\":\"v\"}", CachedValue.class);

            assertEquals("default", CachedValue.defaultValue);
            assertNull(result.cachedValue);
            assertEquals("v", result.value);
        }
    }

    @Nested
    @DisplayName("With @SerializedName")
    class WithSerializedName {

        @Test
        @DisplayName("the value is matched case-insensitively")
        void valueIsMatched() {
            Product result = gson.fromJson("{\"PRODUCT_CODE\":\"p-1\"}", Product.class);

            assertEquals("p-1", result.code);
        }

        @Test
        @DisplayName("an alternate is matched case-insensitively")
        void alternateIsMatched() {
            Product result = gson.fromJson("{\"SKU\":\"p-1\"}", Product.class);

            assertEquals("p-1", result.code);
        }

        @Test
        @DisplayName("an exact alternate takes precedence over a case-insensitive match")
        void exactAlternateTakesPrecedence() {
            Product result = gson.fromJson("{\"sku\":\"exact\",\"PRODUCT_CODE\":\"case-insensitive\"}", Product.class);

            assertEquals("exact", result.code);
        }

        @Test
        @DisplayName("the value is written unchanged")
        void valueIsWrittenUnchanged() {
            Product product = new Product();
            product.code = "p-1";

            assertEquals("{\"product_code\":\"p-1\"}", gson.toJson(product));
        }
    }

    @Nested
    @DisplayName("With ambiguous names")
    class WithAmbiguousNames {

        @Test
        @DisplayName("a key matching two different fields case-insensitively is not bound")
        void ambiguousKeyIsNotBound() {
            Label result = gson.fromJson("{\"text\":\"t\"}", Label.class);

            assertNull(result.text);
            assertNull(result.upperCaseText);
        }

        @Test
        @DisplayName("exact keys are still bound")
        void exactKeysAreBound() {
            Label result = gson.fromJson("{\"Text\":\"t\",\"TEXT\":\"T\"}", Label.class);

            assertEquals("t", result.text);
            assertEquals("T", result.upperCaseText);
        }
    }

    @Nested
    @DisplayName("With a different field naming policy")
    class WithFieldNamingPolicy {

        @Test
        @DisplayName("the configured policy determines the JSON names")
        void configuredPolicyIsRespected() {
            Gson snakeCase = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .registerTypeAdapterFactory(new CaseInsensitiveFieldNamesTypeAdapterFactory(MODEL_PACKAGE))
                    .create();

            Person result = snakeCase.fromJson("{\"FIRST_NAME\":\"Jane\"}", Person.class);

            assertEquals("Jane", result.firstName);
            assertEquals("{\"first_name\":\"Jane\"}", snakeCase.toJson(result));
        }
    }

    private static Gson createGson(String modelPackage) {
        return new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .registerTypeAdapterFactory(new CaseInsensitiveFieldNamesTypeAdapterFactory(modelPackage))
            .create();
    }

    enum Status {
        OPEN,
        SHIPPED,
    }

    static class Person {
        String firstName;
        String lastName;
    }

    static final class Employee extends Person {
        String employeeNumber;
    }

    static final class Order {
        String orderId;
        Person customer;
        List<OrderLine> lines;
    }

    static final class OrderLine {
        String product;
        Integer quantity;
        Status status;
    }

    static final class CachedValue {
        static String defaultValue = "default";
        transient String cachedValue;
        String value;
    }

    static final class Product {
        @SerializedName(value = "product_code", alternate = "sku")
        String code;
    }

    static final class Label {
        String text;
        @SerializedName("TEXT")
        String upperCaseText;
    }
}
