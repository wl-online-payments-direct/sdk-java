package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
class SysOutCommunicatorLoggerTest {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile(
            "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2} (.*)",
            Pattern.DOTALL
    );

    private PrintStream originalSysOut;
    private ByteArrayOutputStream baos;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;

        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    void tearDown() {
        baos = null;
        System.setOut(originalSysOut);
    }

    @Nested
    class WhenLoggingMessageOnly {

        @Test
        void shouldWriteMessageToSystemOut() throws UnsupportedEncodingException {
            SysOutCommunicatorLogger communicatorLogger = SysOutCommunicatorLogger.INSTANCE;
            communicatorLogger.log("Hello world");

            String content = baos.toString("UTF-8");

            assertMessage(content, "Hello world");
        }
    }

    @Nested
    class WhenLoggingMessageWithException {

        @Test
        void shouldWriteMessageAndStackTraceToSystemOut() throws UnsupportedEncodingException {
            SysOutCommunicatorLogger communicatorLogger = SysOutCommunicatorLogger.INSTANCE;
            Exception exception = new Exception();
            communicatorLogger.log("Hello world", exception);

            String content = baos.toString("UTF-8");

            assertMessage(content, "Hello world", exception);
        }
    }

    @Nested
    class WhenLoggingMessageWithExceptionWithCause {

        @Test
        void shouldWriteMessageAndStackTraceIncludingCauseToSystemOut() throws UnsupportedEncodingException {
            SysOutCommunicatorLogger communicatorLogger = SysOutCommunicatorLogger.INSTANCE;

            Exception cause = new Exception("Root cause");
            Exception exception = new Exception("Top level");
            exception.initCause(cause);

            communicatorLogger.log("Hello world", exception);

            String content = baos.toString("UTF-8");

            assertMessage(content, "Hello world", exception);
            assertTrue(content.contains("Caused by"));
            assertTrue(content.contains("Root cause"));
        }
    }

    @Nested
    class WhenLoggingEmptyMessage {

        @Test
        void shouldWriteEmptyMessageToSystemOut() throws UnsupportedEncodingException {
            SysOutCommunicatorLogger communicatorLogger = SysOutCommunicatorLogger.INSTANCE;

            communicatorLogger.log("");

            String content = baos.toString("UTF-8");

            assertMessage(content, "");
        }
    }

    private String toString(Exception exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    private void assertMessage(String content, String message) {
        assertMessage(content, message, null);
    }

    private void assertMessage(String content, String message, Exception exception) {
        String expected = message + System.getProperty("line.separator");
        if (exception != null) {
            expected += toString(exception);
        }

        Matcher matcher = MESSAGE_PATTERN.matcher(content);
        assertTrue(matcher.matches(), "content does not match pattern " + MESSAGE_PATTERN);

        assertEquals(expected, matcher.group(1));
    }
}
