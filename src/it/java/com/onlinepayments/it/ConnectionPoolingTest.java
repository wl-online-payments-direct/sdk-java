package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.domain.TestConnection;

public class ConnectionPoolingTest extends ItTest {

    private static final int REQUEST_COUNT = 10;
    private static final int MAX_CONNECTIONS_EQUAL_TO_REQUEST_COUNT = 10;
    private static final int MAX_CONNECTIONS_LESS_THAN_REQUEST_COUNT = 5;
    private static final int SINGLE_MAX_CONNECTION = 1;

    @Nested
    class WhenTestingConnectionPooling {

        @Nested
        class WithMaxConnectionsEqualToRequestCount {

            @Test
            void shouldHandleConcurrentRequests() throws Exception {
                testConnectionPooling(REQUEST_COUNT, MAX_CONNECTIONS_EQUAL_TO_REQUEST_COUNT);
            }
        }

        @Nested
        class WithMaxConnectionsLessThanRequestCount {

            @Test
            void shouldHandleConcurrentRequests() throws Exception {
                testConnectionPooling(REQUEST_COUNT, MAX_CONNECTIONS_LESS_THAN_REQUEST_COUNT);
            }
        }

        @Nested
        class WithMaxConnectionsOne {

            @Test
            void shouldHandleConcurrentRequests() throws Exception {
                testConnectionPooling(REQUEST_COUNT, SINGLE_MAX_CONNECTION);
            }
        }
    }

    private void testConnectionPooling(int requestCount, int maxConnections) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(requestCount);
        try {
            CommunicatorConfiguration configuration = getCommunicatorConfiguration().withMaxConnections(maxConnections);
            try (Communicator communicator = Factory.createCommunicator(configuration)) {
                executeConnectionPoolingTest(executorService, communicator, requestCount);
            }

        } finally {
            executorService.shutdown();
        }
    }

    private void executeConnectionPoolingTest(ExecutorService executorService, Communicator communicator, int requestCount) throws Exception {
        List<Future<TestConnection>> futures = new ArrayList<>(requestCount);
        CountDownLatch barrier = new CountDownLatch(1);
        for (int i = 0; i < requestCount; i++) {
            Future<TestConnection> future = executorService.submit(new TestAction(barrier, communicator));
            futures.add(future);
        }
        barrier.countDown();

        for (Future<TestConnection> future : futures) {
            TestConnection result = future.get();
            assertNotNull(result);
            assertNotNull(result.getResult());
        }
    }

    private static final class TestAction implements Callable<TestConnection> {

        private final CountDownLatch barrier;
        private final Communicator communicator;

        private TestAction(CountDownLatch barrier, Communicator communicator) {
            this.barrier = barrier;
            this.communicator = communicator;
        }

        @Override
        public TestConnection call() throws Exception {
            barrier.await();

            return Factory.createClient(communicator)
                    .withClientMetaInfo("")
                    .merchant(getMerchantId())
                    .services()
                    .testConnection();
        }
    }
}
