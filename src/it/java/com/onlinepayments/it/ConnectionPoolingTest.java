package com.onlinepayments.it;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;

public class ConnectionPoolingTest extends ItTest {

    @Test
    public void testConnectionPoolingMaxIsRequestCount() throws Exception {
        testConnectionPooling(10, 10);
    }

    @Test
    public void testConnectionPoolingMaxIsHalfRequestCount() throws Exception {
        testConnectionPooling(10, 5);
    }

    @Test
    public void testConnectionPoolingMaxIsOne() throws Exception {
        testConnectionPooling(10, 1);
    }

    private void testConnectionPooling(int requestCount, int maxConnections) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(requestCount);
        try {

            CommunicatorConfiguration configuration = getCommunicatorConfiguration().withMaxConnections(maxConnections);
            Communicator communicator = Factory.createCommunicator(configuration);
            try {

                testConnectionPooling(executorService, communicator, requestCount);

            } finally {
                communicator.close();
            }

        } finally {
            executorService.shutdown();
        }
    }

    private void testConnectionPooling(ExecutorService executorService, Communicator communicator, int requestCount) throws Exception {

        List<Future<TestResult>> futures = new ArrayList<Future<TestResult>>(requestCount);
        CountDownLatch barrier = new CountDownLatch(1);
        for (int i = 0; i < requestCount; i++) {
            Future<TestResult> future = executorService.submit(new TestAction(barrier, communicator));
            futures.add(future);
        }
        barrier.countDown();

        for (Future<TestResult> future : futures) {
            future.get();
        }
        // actual concurrent use of connections will need to be verified in the server logs
    }

    private static final class TestAction implements Callable<TestResult> {

        private final CountDownLatch barrier;
        private final Communicator communicator;

        private TestAction(CountDownLatch barrier, Communicator communicator) {
            this.barrier = barrier;
            this.communicator = communicator;
        }

        @Override
        public TestResult call() throws Exception {

            barrier.await();

            long startTime = System.currentTimeMillis();
            Factory.createClient(communicator).withClientMetaInfo("").merchant(getMerchantId()).services().testConnection();
            long endTime = System.currentTimeMillis();

            return new TestResult(startTime, endTime);
        }
    }

    private static final class TestResult {

        @SuppressWarnings("unused")
        private final long startTime;
        @SuppressWarnings("unused")
        private final long endTime;

        private TestResult(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
