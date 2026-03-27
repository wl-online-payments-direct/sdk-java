package com.onlinepayments.json;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

class DefaultMarshallerTest {

    @Test
    void testUnmarshalWithExtraFields() {
        ObjectWithExtraField original = new ObjectWithExtraField();
        original.setId("1234");
        original.setExtraField("extra-field-value");

        String json = DefaultMarshaller.INSTANCE.marshal(original);

        BasicObject unmarshalled = DefaultMarshaller.INSTANCE.unmarshal(json, BasicObject.class);

        assertEquals("1234", unmarshalled.getId());
    }

    @Test
    void testMarshalDateAndDateTime() {
        ObjectWithDates object = new ObjectWithDates();
        object.setDate(LocalDate.of(2023, 12, 31));
        object.setDateTime(ZonedDateTime.of(2023, 12, 31, 13, 24, 59, 123_456_789, ZoneOffset.ofHours(2)));

        String json = DefaultMarshaller.INSTANCE.marshal(object);

        assertThat(json, containsString("\"2023-12-31\""));
        assertThat(json, containsString("\"2023-12-31T13:24:59.123+02:00\""));
    }

    @Test
    void testUnmarshalDateAndDateTime() {
        String json = "{\"date\": \"2023-12-31\", \"dateTime\": \"2023-12-31T13:24:59.123+02:00\"}";

        ObjectWithDates object = DefaultMarshaller.INSTANCE.unmarshal(json, ObjectWithDates.class);

        assertEquals(LocalDate.of(2023, 12, 31), object.getDate());
        assertEquals(ZonedDateTime.of(2023, 12, 31, 13, 24, 59, 123_000_000, ZoneOffset.ofHours(2)), object.getDateTime());
    }

    @Test
    void testUnmarshalDateTimeZ() {
        String json = "{\"dateTime\": \"2023-12-31T13:24:59.123Z\"}";

        ObjectWithDates object = DefaultMarshaller.INSTANCE.unmarshal(json, ObjectWithDates.class);

        assertEquals(ZonedDateTime.of(2023, 12, 31, 13, 24, 59, 123_000_000, ZoneOffset.of("Z")), object.getDateTime());
        assertEquals(0, object.getDateTime().getOffset().getTotalSeconds());
    }

    @Test
    void testUnmarshalZonedDateTimeWithValidOffset() {

        String fullTimezone = "\"2026-03-26T12:34:56+01:00\"";
        ZonedDateTime expectedFullTimezone = ZonedDateTime.parse("2026-03-26T12:34:56+01:00");
        ZonedDateTime parsedFullTimezone = DefaultMarshaller.INSTANCE.unmarshal(fullTimezone, ZonedDateTime.class);

        assertEquals(expectedFullTimezone.toInstant(), parsedFullTimezone.toInstant(),
                "Parsed date does not match expected value");
        assertEquals(expectedFullTimezone.getOffset(), parsedFullTimezone.getOffset(),
                "Offset does not match expected value");
        assertEquals(fullTimezone, DefaultMarshaller.INSTANCE.marshal(parsedFullTimezone),
                "Marshaled JSON does not match expected value");

        String shortTimezone = "\"2026-03-26T12:34:56+01\"";
        ZonedDateTime expectedShortTimezone = ZonedDateTime.parse("2026-03-26T12:34:56+01:00");
        ZonedDateTime parsedShortTimezone = DefaultMarshaller.INSTANCE.unmarshal(shortTimezone, ZonedDateTime.class);

        assertEquals(expectedShortTimezone.toInstant(), parsedShortTimezone.toInstant(),
                "Parsed date does not match expected value");
        assertEquals(expectedShortTimezone.getOffset(), parsedShortTimezone.getOffset(),
                "Offset does not match expected value");
        assertEquals("\"2026-03-26T12:34:56+01:00\"", DefaultMarshaller.INSTANCE.marshal(parsedShortTimezone),
                "Marshaled JSON does not match expected value");
    }

    @Test
    void testUnmarshalZonedDateTimeWithInvalidOffset() {

        String withoutOffset = "\"2026-03-10T11:14:15\"";
        assertThrows(DateTimeParseException.class,
                () -> DefaultMarshaller.INSTANCE.unmarshal(withoutOffset, ZonedDateTime.class),
                "Expected error for date without offset.");

        String justDate = "\"2026-03-10\"";
        assertThrows(DateTimeParseException.class,
                () -> DefaultMarshaller.INSTANCE.unmarshal(justDate, ZonedDateTime.class),
                "Expected error for invalid date with just date.");
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
}
