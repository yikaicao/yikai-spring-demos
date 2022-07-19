public class StackOverflowMain {
    private int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        StackOverflowMain main = new StackOverflowMain();
        try {
            main.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + main.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
