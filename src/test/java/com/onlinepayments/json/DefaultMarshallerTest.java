package com.onlinepayments.json;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

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
