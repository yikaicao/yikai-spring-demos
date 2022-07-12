import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeMain {

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch latch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        System.out.println("count=" + example.getCount());
    }
}
