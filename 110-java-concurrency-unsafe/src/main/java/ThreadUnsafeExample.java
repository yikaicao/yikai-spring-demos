public class ThreadUnsafeExample {
    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
