public class App {
    private static int counter = 0;
    private static final int ITERATIONS = 1000000;
    private static CustomReentrantLock reentrantLock = new CustomReentrantLock();
    private static boolean enableLocking = false;

    private static Runnable changeCounterFactory(int value) {
        return enableLocking ? () -> {
            for (int i = 0; i < ITERATIONS; ++i) {
                reentrantLock.lock();
                counter += value;
                reentrantLock.unlock();
            }
        } : () -> {
            for (int i = 0; i < ITERATIONS; ++i) {
                counter += value;
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(changeCounterFactory(1));
        var t2 = new Thread(changeCounterFactory(1));
        var t3 = new Thread(changeCounterFactory(-2));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(counter);
    }
}
