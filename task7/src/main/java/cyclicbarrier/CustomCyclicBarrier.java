package cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;

public class CustomCyclicBarrier {
    private final int threadsAmount;
    private int threadsLeft;
    private final Runnable barrierEvent;
    private boolean isBroken;

    public CustomCyclicBarrier(int threadsAmount, Runnable barrierEvent) {
        this.threadsAmount = threadsAmount;
        this.threadsLeft = threadsAmount;
        this.barrierEvent = barrierEvent;
        this.isBroken = false;
    }

    public synchronized void await() throws InterruptedException, BrokenBarrierException {
        if (this.isBroken) {
            throw new BrokenBarrierException();
        }

        this.threadsLeft--;

        if (this.threadsLeft > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                this.isBroken = true;
                throw e;
            }
        } else {
            this.threadsLeft = this.threadsAmount;
            notifyAll();

            this.barrierEvent.run();
        }
    }
}
