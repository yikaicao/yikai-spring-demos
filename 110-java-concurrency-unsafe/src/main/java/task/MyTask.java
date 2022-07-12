package task;

public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("hi, my current thread is" + Thread.currentThread()); // this won't print
    }
}
