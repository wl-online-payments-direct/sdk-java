package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.ProblemDetailsException;
import com.onlinepayments.domain.ProblemDetailsResponse;

public class ProblemDetailsExceptionTest {

    @Nested
    class WhenCreated {

        @Test
        void withStatusCodeShouldStoreStatusCode() {
            ProblemDetailsException exception = build(422, null, null);

            assertEquals(422, exception.getStatusCode());
        }

        @Test
        void withResponseBodyShouldStoreResponseBody() {
            ProblemDetailsException exception = build(null, "{\"type\":\"problem\"}", null);

            assertEquals("{\"type\":\"problem\"}", exception.getResponseBody());
        }

        @Test
        void withResponseObjectShouldStoreResponseObject() {
            ProblemDetailsResponse response = new ProblemDetailsResponse();
            ProblemDetailsException exception = build(null, null, response);

            assertSame(response, exception.getResponse());
        }

        @Test
        void withNullResponseBodyShouldStoreNullResponseBody() {
            ProblemDetailsException exception = new ProblemDetailsException(400, null, new ProblemDetailsResponse());

            assertNull(exception.getResponseBody());
        }

        @Test
        void withNullResponseObjectShouldStoreNullResponseObject() {
            ProblemDetailsException exception = new ProblemDetailsException(400, "body", null);

            assertNull(exception.getResponse());
        }
    }

    @Nested
    class WhenGettingResponse {

        @Test
        void withDefaultScenarioShouldReturnResponsePassedAtConstruction() {
            ProblemDetailsResponse response = new ProblemDetailsResponse();
            ProblemDetailsException exception = build(null, null, response);

            assertSame(response, exception.getResponse());
        }
    }

    @Nested
    class WhenConvertingToString {

        @Test
        void whenDefaultScenarioShouldIncludeProblemDetailsInMessage() {
            ProblemDetailsException exception = build(null, null, null);

            assertTrue(exception.getMessage().contains("problem details"));
        }
    }

    @Nested
    class WhenInheritance {

        @Test
        void withDefaultScenarioChecksIsInstanceOfProblemDetailsException() {
            ProblemDetailsException exception = build(null, null, null);

            assertInstanceOf(ProblemDetailsException.class, exception);
        }

        @Test
        void withDefaultScenarioCheckIsInstanceOfApiException() {
            ProblemDetailsException exception = build(null, null, null);

            assertInstanceOf(ApiException.class, exception);
        }

        @Test
        void withDefaultScenarioCheckIsInstanceOfRuntimeException() {
            ProblemDetailsException exception = build(null, null, null);

            assertInstanceOf(RuntimeException.class, exception);
        }

        @Test
        void withDefaultScenarioCheckIsCatchableAsApiException() {
            ProblemDetailsException exception = build(500, "error", null);

            assertThrows(ApiException.class, () -> {
                throw exception;
            });
        }
    }

    private static ProblemDetailsException build(
            Integer statusCode,
            String responseBody,
            ProblemDetailsResponse response) {
        if (statusCode == null) {
            statusCode = 400;
        }

        if (responseBody == null) {
            responseBody = "body";
        }

        if (response == null) {
            response = new ProblemDetailsResponse();
        }

        return new ProblemDetailsException(statusCode, responseBody, response);
    }
}
