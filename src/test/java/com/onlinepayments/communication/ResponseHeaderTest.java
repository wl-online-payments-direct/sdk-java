package com.onlinepayments.communication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ResponseHeaderTest {

    @Test
    void testGetDispositionFilename() {
        Map<String, String> testData = new LinkedHashMap<>();
        testData.put("attachment; filename=testfile", "testfile");
        testData.put("attachment; filename=\"testfile\"", "testfile");
        testData.put("attachment; filename=\"testfile", "\"testfile");
        testData.put("attachment; filename=testfile\"", "testfile\"");
        testData.put("attachment; filename='testfile'", "testfile");
        testData.put("attachment; filename='testfile", "'testfile");
        testData.put("attachment; filename=testfile'", "testfile'");

        testData.put("filename=testfile", "testfile");
        testData.put("filename=\"testfile\"", "testfile");
        testData.put("filename=\"testfile", "\"testfile");
        testData.put("filename=testfile\"", "testfile\"");
        testData.put("filename='testfile'", "testfile");
        testData.put("filename='testfile", "'testfile");
        testData.put("filename=testfile'", "testfile'");

        testData.put("attachment; filename=testfile; x=y", "testfile");
        testData.put("attachment; filename=\"testfile\"; x=y", "testfile");
        testData.put("attachment; filename=\"testfile; x=y", "\"testfile");
        testData.put("attachment; filename=testfile\"; x=y", "testfile\"");
        testData.put("attachment; filename='testfile'; x=y", "testfile");
        testData.put("attachment; filename='testfile; x=y", "'testfile");
        testData.put("attachment; filename=testfile'; x=y", "testfile'");

        testData.put("attachment", null);

        testData.put("filename=\"", "\"");
        testData.put("filename='", "'");

        for (Map.Entry<String, String> entry : testData.entrySet()) {
            ResponseHeader header = new ResponseHeader("Content-Disposition", entry.getKey());
            assertEquals(entry.getValue(), ResponseHeader.getDispositionFilename(Collections.singletonList(header)));
        }
    }
}
