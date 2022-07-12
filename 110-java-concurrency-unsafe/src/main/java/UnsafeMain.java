import task.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeMain {

    public static void main(String[] args) throws InterruptedException {
        daemonThreadExample();
        countExample();
//        printNumExampleSameThread();
//        printNumExampleDifferentThread();
        //printNumExampleDifferentThreadUnsafe();
        waitExample();
    }

    private static void countExample() throws InterruptedException {
        System.out.println("count example: ");
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
        System.out.println("should have returned 1000, but count=" + example.getCount());
    }

    private static void daemonThreadExample() {
        Thread thread = new Thread(new MyTask());
        thread.setDaemon(true);
        thread.start();
    }

    private static void printNumExampleSameThread() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable aTask = new PrintNumSequentially();
        executorService.execute(aTask);
        executorService.execute(aTask);
        executorService.shutdown();
    }

    private static void printNumExampleDifferentThread() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable aTask = new PrintNumSequentially();
        Runnable bTask = new PrintNumSequentially();
        executorService.execute(aTask);
        executorService.execute(bTask);
        executorService.shutdown();
    }

    private static void printNumExampleDifferentThreadUnsafe() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PrintNumUnsafe aTask = new PrintNumUnsafe();
        PrintNumUnsafe bTask = new PrintNumUnsafe();
        executorService.execute(()->aTask.printNum());
        executorService.execute(()->bTask.printNum());
        executorService.shutdown();
    }

    private static void waitExample() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
        executorService.shutdown();
    }
}

