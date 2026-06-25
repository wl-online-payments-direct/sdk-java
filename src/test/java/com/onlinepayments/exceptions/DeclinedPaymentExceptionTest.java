package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.PaymentErrorResponse;

class DeclinedPaymentExceptionTest {

    @Nested
    class WhenDeclinedPaymentExceptionIsCreated {

        @Nested
        class WithValidPaymentErrorResponse {

            @Test
            void shouldExposeExpectedProperties() {
                CreatePaymentResponse createPaymentResponse = mock(CreatePaymentResponse.class);
                PaymentErrorResponse response = mock(PaymentErrorResponse.class);

                when(response.getPaymentResult()).thenReturn(createPaymentResponse);

                DeclinedPaymentException exception = new DeclinedPaymentException(
                        402,
                        "{\"error\":\"declined\"}",
                        response
                );

                assertEquals(402, exception.getStatusCode());
                assertEquals("{\"error\":\"declined\"}", exception.getResponseBody());
                assertSame(createPaymentResponse, exception.getCreatePaymentResponse());
            }
        }
    }
}
