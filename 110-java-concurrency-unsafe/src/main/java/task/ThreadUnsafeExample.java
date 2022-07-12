package task;

public class ThreadUnsafeExample {
    private int count = 0;

    public void add() {
        //System.out.println(Thread.currentThread());
        count++;
    }

    public int getCount() {
        return count;
    }
}
