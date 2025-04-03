package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class JdkCommunicatorLoggerTest {

    @Test
    void testLog() {

        Logger logger = Logger.getLogger(getClass().getName());
        TestHandler handler = new TestHandler();
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

    @Test
    void testLogWithException() {

        Logger logger = Logger.getLogger(getClass().getName());
        TestHandler handler = new TestHandler();
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
