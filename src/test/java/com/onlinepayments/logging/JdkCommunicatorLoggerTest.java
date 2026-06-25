package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JdkCommunicatorLoggerTest {

    private Logger logger;
    private TestHandler handler;

    @AfterEach
    void tearDown() {
        if (logger != null && handler != null) {
            logger.removeHandler(handler);
        }
    }

    @Nested
    @DisplayName("Constructing with Two Parameters")
    class WhenConstructingWithTwoParameters {

        @Test
        void shouldCreateInstanceWithSingleLevel() {
            Logger testLogger = Logger.getLogger("test");
            JdkCommunicatorLogger communicatorLogger = new JdkCommunicatorLogger(testLogger, Level.FINE);

            assertNotNull(communicatorLogger);
        }

        @Test
        void shouldUseSameLevelForBothLogAndLogWithThrowable() {
            logger = Logger.getLogger(getClass().getName());
            handler = new TestHandler();
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);

            JdkCommunicatorLogger communicatorLogger = new JdkCommunicatorLogger(logger, Level.FINE);
            communicatorLogger.log("Message 1");
            communicatorLogger.log("Message 2", new Exception());

            assertEquals(2, handler.records.size());
            assertEquals(Level.FINE, handler.records.get(0).getLevel());
            assertEquals(Level.FINE, handler.records.get(1).getLevel());
        }
    }

    @Nested
    @DisplayName("Constructing with Null Parameters")
    class WhenConstructingWithNullParameters {

        @Test
        void shouldThrowExceptionWhenLoggerIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new JdkCommunicatorLogger(null, Level.INFO, Level.WARNING));
        }

        @Test
        void shouldThrowExceptionWhenLogLevelIsNull() {
            Logger testLogger = Logger.getLogger("test");
            assertThrows(IllegalArgumentException.class, () -> new JdkCommunicatorLogger(testLogger, null, Level.WARNING));
        }

        @Test
        void shouldThrowExceptionWhenErrorLogLevelIsNull() {
            Logger testLogger = Logger.getLogger("test");
            assertThrows(IllegalArgumentException.class, () -> new JdkCommunicatorLogger(testLogger, Level.INFO, null));
        }
    }

    @Nested
    class WhenLoggingMessageOnly {

        @Test
        void shouldCreateInfoLogRecord() {
            logger = Logger.getLogger(getClass().getName());
            handler = new TestHandler();
            logger.addHandler(handler);

            JdkCommunicatorLogger communicatorLogger = new JdkCommunicatorLogger(logger, Level.INFO, Level.WARNING);
            communicatorLogger.log("Hello world");

            assertEquals(1, handler.records.size());

            LogRecord record = handler.records.get(0);

            assertEquals("Hello world", record.getMessage());
            assertEquals(Level.INFO, record.getLevel());
            assertEquals(getClass().getName(), record.getLoggerName());
            assertEquals(communicatorLogger.getClass().getName(), record.getSourceClassName());
            assertEquals("log", record.getSourceMethodName());
            assertNull(record.getThrown());
        }
    }

    @Nested
    class WhenLoggingMessageWithException {

        @Test
        void shouldCreateWarningLogRecordWithThrownException() {
            logger = Logger.getLogger(getClass().getName());
            handler = new TestHandler();
            logger.addHandler(handler);

            JdkCommunicatorLogger communicatorLogger = new JdkCommunicatorLogger(logger, Level.INFO, Level.WARNING);
            Exception exception = new Exception();
            communicatorLogger.log("Hello world", exception);

            assertEquals(1, handler.records.size());

            LogRecord record = handler.records.get(0);

            assertEquals("Hello world", record.getMessage());
            assertEquals(Level.WARNING, record.getLevel());
            assertEquals(getClass().getName(), record.getLoggerName());
            assertEquals(communicatorLogger.getClass().getName(), record.getSourceClassName());
            assertEquals("log", record.getSourceMethodName());
            assertSame(exception, record.getThrown());
        }
    }

    private static final class TestHandler extends Handler {

        private final List<LogRecord> records = new ArrayList<>();

        @Override
        public void publish(LogRecord record) {
            records.add(record);
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }
    }
}
