package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.DeclinedPayoutException;
import com.onlinepayments.domain.PayoutErrorResponse;
import com.onlinepayments.domain.PayoutResult;

class DeclinedPayoutExceptionTest {

    @Nested
    class WhenDeclinedPayoutExceptionIsCreated {

        @Nested
        class WithValidPayoutErrorResponse {

            @Test
            void shouldExposeExpectedProperties() {
                PayoutResult payoutResult = mock(PayoutResult.class);
                when(payoutResult.getId()).thenReturn("payout-id");
                when(payoutResult.getStatus()).thenReturn("REJECTED");

                PayoutErrorResponse response = mock(PayoutErrorResponse.class);
                when(response.getErrorId()).thenReturn("payout-error-id");
                when(response.getErrors()).thenReturn(Collections.emptyList());
                when(response.getPayoutResult()).thenReturn(payoutResult);

                DeclinedPayoutException exception = new DeclinedPayoutException(
                        402,
                        "{\"error\":\"declined\"}",
                        response
                );

                assertEquals("declined payout 'payout-id' with status 'REJECTED'", exception.getMessage());
                assertEquals(402, exception.getStatusCode());
                assertEquals("{\"error\":\"declined\"}", exception.getResponseBody());
                assertSame(payoutResult, exception.getPayoutResult());
            }
        }
    }
}
