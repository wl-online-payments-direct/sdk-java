/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.sessions;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PaymentPlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.SessionRequest;
import com.onlinepayments.domain.SessionResponse;

/**
 * Sessions client. Thread-safe.
 */
public interface SessionsClientInterface {

	/**
	 * Resource /v2/{merchantId}/sessions
	 * - Create session
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws PaymentPlatformException if something went wrong at the payment platform,
	 *            the payment platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the payment platform returned any other error
	 */
	SessionResponse createSession(SessionRequest body);

	/**
	 * Resource /v2/{merchantId}/sessions
	 * - Create session
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws PaymentPlatformException if something went wrong at the payment platform,
	 *            the payment platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the payment platform returned any other error
	 */
	SessionResponse createSession(SessionRequest body, CallContext context);
}
