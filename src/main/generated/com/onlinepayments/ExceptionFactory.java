/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.Collections;
import java.util.List;

import com.onlinepayments.domain.APIError;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.PaymentErrorResponse;
import com.onlinepayments.domain.PayoutErrorResponse;
import com.onlinepayments.domain.RefundErrorResponse;

/**
 * Factory for exceptions thrown by Payment platform API v2 resources.
 */
public class ExceptionFactory {

    public RuntimeException createException(int statusCode, String responseBody, Object errorObject, CallContext context) {
        if (errorObject instanceof PaymentErrorResponse) {
            PaymentErrorResponse paymentErrorResponse = (PaymentErrorResponse) errorObject;
            if (paymentErrorResponse.getPaymentResult() != null) {
                return new DeclinedPaymentException(statusCode, responseBody, paymentErrorResponse);
            }
            return createException(statusCode, responseBody, paymentErrorResponse.getErrorId(), paymentErrorResponse.getErrors(), context);
        }
        if (errorObject instanceof PayoutErrorResponse) {
            PayoutErrorResponse payoutErrorResponse = (PayoutErrorResponse) errorObject;
            if (payoutErrorResponse.getPayoutResult() != null) {
                return new DeclinedPayoutException(statusCode, responseBody, payoutErrorResponse);
            }
            return createException(statusCode, responseBody, payoutErrorResponse.getErrorId(), payoutErrorResponse.getErrors(), context);
        }
        if (errorObject instanceof RefundErrorResponse) {
            RefundErrorResponse refundErrorResponse = (RefundErrorResponse) errorObject;
            if (refundErrorResponse.getRefundResult() != null) {
                return new DeclinedRefundException(statusCode, responseBody, refundErrorResponse);
            }
            return createException(statusCode, responseBody, refundErrorResponse.getErrorId(), refundErrorResponse.getErrors(), context);
        }
        if (errorObject instanceof ErrorResponse) {
            ErrorResponse errorResponse = (ErrorResponse) errorObject;
            return createException(statusCode, responseBody, errorResponse.getErrorId(), errorResponse.getErrors(), context);
        }
        if (errorObject == null) {
            return createException(statusCode, responseBody, null, Collections.emptyList(), context);
        }
        throw new IllegalArgumentException("unsupported error object type: " + errorObject.getClass().getName());
    }

    private RuntimeException createException(int statusCode, String responseBody, String errorId, List<APIError> errors, CallContext context) {
        switch (statusCode) {
        case 400:
            return new ValidationException(statusCode, responseBody, errorId, errors);
        case 403:
            return new AuthorizationException(statusCode, responseBody, errorId, errors);
        case 404:
            return new ReferenceException(statusCode, responseBody, errorId, errors);
        case 409:
            if (isIdempotenceError(errors, context)) {
                String idempotenceKey = context.getIdempotenceKey();
                Long idempotenceRequestTimestamp = context.getIdempotenceRequestTimestamp();
                return new IdempotenceException(idempotenceKey, idempotenceRequestTimestamp, statusCode, responseBody, errorId, errors);
            }
            return new ReferenceException(statusCode, responseBody, errorId, errors);
        case 410:
            return new ReferenceException(statusCode, responseBody, errorId, errors);
        case 500:
            return new PlatformException(statusCode, responseBody, errorId, errors);
        case 502:
            return new PlatformException(statusCode, responseBody, errorId, errors);
        case 503:
            return new PlatformException(statusCode, responseBody, errorId, errors);
        default:
            return new ApiException(statusCode, responseBody, errorId, errors);
        }
    }

    private static boolean isIdempotenceError(List<APIError> errors, CallContext context) {
        return context != null
                && context.getIdempotenceKey() != null
                && errors != null
                && errors.size() == 1
                && "1409".equals(errors.get(0).getErrorCode());
    }
}
