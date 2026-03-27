package com.onlinepayments.json;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

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

        public static final DateTimeFormatter ISO_DATE_TIME_SHORT_OFFSET;

        static {
            ISO_DATE_TIME_SHORT_OFFSET = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(ISO_LOCAL_DATE_TIME)
                .appendOffset("+HH", "Z")
                .toFormatter();
        }

        private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
                DateTimeFormatter.ISO_OFFSET_DATE_TIME,
                ISO_DATE_TIME_SHORT_OFFSET
        );

        @Override
        @SuppressWarnings("resource")
        public void write(JsonWriter out, ZonedDateTime value) throws IOException {
            out.value(value.truncatedTo(ChronoUnit.MILLIS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        }

        @Override
        public ZonedDateTime read(JsonReader in) throws IOException {
            String value = in.nextString();

            for (DateTimeFormatter formatter : FORMATTERS) {
                try {
                    return ZonedDateTime.parse(value, formatter);
                } catch (DateTimeParseException ignored) {
                    // try next formatter
                }
            }

            throw new DateTimeParseException("Unable to parse date", value, 0);
        }
    }
}
