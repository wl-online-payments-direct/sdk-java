package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.DeclinedRefundException;
import com.onlinepayments.domain.RefundErrorResponse;
import com.onlinepayments.domain.RefundResponse;

class DeclinedRefundExceptionTest {

    @Nested
    class WhenDeclinedRefundExceptionIsCreated {

        @Nested
        class WithValidRefundErrorResponse {

            @Test
            void shouldExposeExpectedProperties() {
                RefundResponse refundResponse = mock(RefundResponse.class);
                when(refundResponse.getId()).thenReturn("refund-id");
                when(refundResponse.getStatus()).thenReturn("REJECTED");

                RefundErrorResponse response = mock(RefundErrorResponse.class);
                when(response.getErrorId()).thenReturn("refund-error-id");
                when(response.getErrors()).thenReturn(Collections.emptyList());
                when(response.getRefundResult()).thenReturn(refundResponse);

                DeclinedRefundException exception = new DeclinedRefundException(
                        402,
                        "{\"error\":\"declined\"}",
                        response
                );

                assertEquals("declined refund 'refund-id' with status 'REJECTED'", exception.getMessage());
                assertEquals(402, exception.getStatusCode());
                assertEquals("{\"error\":\"declined\"}", exception.getResponseBody());
                assertSame(refundResponse, exception.getRefundResponse());
            }
        }
    }
}
