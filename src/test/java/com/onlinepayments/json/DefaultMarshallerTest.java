package com.onlinepayments.json;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DefaultMarshallerTest {

    @Nested
    class WhenUnmarshallingObjectWithExtraFields {

        @Test
        void shouldIgnoreUnknownFields() {
            ObjectWithExtraField original = new ObjectWithExtraField();
            original.setId("1234");
            original.setExtraField("extra-field-value");

            String json = DefaultMarshaller.INSTANCE.marshal(original);

            BasicObject unmarshalled = DefaultMarshaller.INSTANCE.unmarshal(json, BasicObject.class);

            assertEquals("1234", unmarshalled.getId());
        }
    }

    @Nested
    class WhenMarshallingObjectWithDateAndDateTime {

        @Test
        void shouldReturnExpectedJsonValues() {
            ObjectWithDates object = new ObjectWithDates();
            object.setDate(LocalDate.of(2023, 12, 31));
            object.setDateTime(ZonedDateTime.of(
                    2023, 12, 31, 13, 24, 59, 123_456_789, ZoneOffset.ofHours(2)
            ));

            String json = DefaultMarshaller.INSTANCE.marshal(object);

            assertThat(json, containsString("\"2023-12-31\""));
            assertThat(json, containsString("\"2023-12-31T13:24:59.123+02:00\""));
        }
    }

    @Nested
    class WhenUnmarshallingDateAndDateTimeJson {

        @Test
        void shouldReturnExpectedObject() {
            String json = "{\"date\": \"2023-12-31\", \"dateTime\": \"2023-12-31T13:24:59.123+02:00\"}";

            ObjectWithDates object = DefaultMarshaller.INSTANCE.unmarshal(json, ObjectWithDates.class);

            assertEquals(LocalDate.of(2023, 12, 31), object.getDate());
            assertEquals(
                    ZonedDateTime.of(2023, 12, 31, 13, 24, 59, 123_000_000, ZoneOffset.ofHours(2)),
                    object.getDateTime()
            );
        }
    }

    @Nested
    class WhenUnmarshallingZuluDateTime {

        @Test
        void shouldReturnUtcZonedDateTime() {
            String json = "{\"dateTime\": \"2023-12-31T13:24:59.123Z\"}";

            ObjectWithDates object = DefaultMarshaller.INSTANCE.unmarshal(json, ObjectWithDates.class);

            assertEquals(
                    ZonedDateTime.of(2023, 12, 31, 13, 24, 59, 123_000_000, ZoneOffset.of("Z")),
                    object.getDateTime()
            );
            assertEquals(0, object.getDateTime().getOffset().getTotalSeconds());
        }
    }

    @Nested
    class WhenUnmarshallingValidZonedDateTimes {

        @Test
        void shouldParseAndMarshalFullTimezoneOffset() {
            String fullTimezone = "\"2026-03-26T12:34:56+01:00\"";
            ZonedDateTime expectedFullTimezone = ZonedDateTime.parse("2026-03-26T12:34:56+01:00");
            ZonedDateTime parsedFullTimezone = DefaultMarshaller.INSTANCE.unmarshal(fullTimezone, ZonedDateTime.class);

            assertEquals(expectedFullTimezone.toInstant(), parsedFullTimezone.toInstant());
            assertEquals(expectedFullTimezone.getOffset(), parsedFullTimezone.getOffset());
            assertEquals(fullTimezone, DefaultMarshaller.INSTANCE.marshal(parsedFullTimezone));
        }

        @Test
        void shouldParseAndMarshalShortTimezoneOffset() {
            String shortTimezone = "\"2026-03-26T12:34:56+01\"";
            ZonedDateTime expectedShortTimezone = ZonedDateTime.parse("2026-03-26T12:34:56+01:00");
            ZonedDateTime parsedShortTimezone = DefaultMarshaller.INSTANCE.unmarshal(shortTimezone, ZonedDateTime.class);

            assertEquals(expectedShortTimezone.toInstant(), parsedShortTimezone.toInstant());
            assertEquals(expectedShortTimezone.getOffset(), parsedShortTimezone.getOffset());
            assertEquals("\"2026-03-26T12:34:56+01:00\"", DefaultMarshaller.INSTANCE.marshal(parsedShortTimezone));
        }
    }

    @Nested
    class WhenUnmarshallingInvalidZonedDateTimes {

        @Test
        void shouldThrowDateTimeParseException() {

            String withoutOffset = "\"2026-03-10T11:14:15\"";
            assertThrows(
                    DateTimeParseException.class,
                    () -> DefaultMarshaller.INSTANCE.unmarshal(withoutOffset, ZonedDateTime.class)
            );

            String justDate = "\"2026-03-10\"";
            assertThrows(
                    DateTimeParseException.class,
                    () -> DefaultMarshaller.INSTANCE.unmarshal(justDate, ZonedDateTime.class)
            );
        }
    }

    @Nested
    class WhenUnmarshallingWithInputStream {

        @Test
        void shouldReturnExpectedObject() {
            String json = "{\"date\": \"2023-12-31\", \"dateTime\": \"2023-12-31T13:24:59.123+02:00\"}";

            ObjectWithDates object = DefaultMarshaller.INSTANCE.unmarshal(
                new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)),
                    ObjectWithDates.class
            );

            assertEquals(LocalDate.of(2023, 12, 31), object.getDate());
            assertEquals(
                    ZonedDateTime.of(2023, 12, 31, 13, 24, 59, 123_000_000, ZoneOffset.ofHours(2)),
                    object.getDateTime()
            );
        }
    }

    @Nested
    class WhenMarshallingObjectWithNullDateFields {

        @Test
        void shouldNotSerializeNullDateFields() {
            ObjectWithDates object = new ObjectWithDates();
            object.setDate(null);
            object.setDateTime(null);

            String json = DefaultMarshaller.INSTANCE.marshal(object);

            assertEquals("{}", json);
        }
    }

    @Nested
    class WhenMarshallingObjectWithListField {

        @Test
        void shouldRoundTripObjectWithListField() {
            ObjectWithListField original = new ObjectWithListField();
            original.setValues(Arrays.asList("first", "second", "third"));

            String json = DefaultMarshaller.INSTANCE.marshal(original);

            ObjectWithListField unmarshalled = DefaultMarshaller.INSTANCE.unmarshal(json, ObjectWithListField.class);

            assertEquals(original.getValues(), unmarshalled.getValues());
        }
    }

    @Nested
    class WhenMarshallingNullObject {

        @Test
        void shouldReturnJsonNull() {
            String json = DefaultMarshaller.INSTANCE.marshal(null);

            assertEquals("null", json);
        }
    }

    @Nested
    class WhenUnmarshallingNull {

        @Test
        void shouldReturnNull() {
            BasicObject object = DefaultMarshaller.INSTANCE.unmarshal((String) null, BasicObject.class);

            assertNull(object);
        }
    }

    static class BasicObject {

        private String id;

        String getId() {
            return id;
        }

        void setId(String id) {
            this.id = id;
        }
    }

    static final class ObjectWithExtraField extends BasicObject {

        private String extraField;

        String getExtraField() {
            return extraField;
        }

        void setExtraField(String extraField) {
            this.extraField = extraField;
        }
    }

    static final class ObjectWithDates {

        private LocalDate date;
        private ZonedDateTime dateTime;

        LocalDate getDate() {
            return date;
        }

        void setDate(LocalDate date) {
            this.date = date;
        }

        ZonedDateTime getDateTime() {
            return dateTime;
        }

        void setDateTime(ZonedDateTime dateTime) {
            this.dateTime = dateTime;
        }
    }

    static final class ObjectWithListField {

        private List<String> values;

        List<String> getValues() {
            return values;
        }

        void setValues(List<String> values) {
            this.values = values;
        }
    }
}
