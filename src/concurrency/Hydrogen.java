package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Hydrogen implements Runnable {
    private final CyclicBarrier cyclicBarrier;

    Hydrogen(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void releaseHydrogen(){
        System.out.print("H");
    }

    public void run() {
        try {
            cyclicBarrier.await();
            releaseHydrogen();
        } catch (InterruptedException ex) {
            return;
        } catch (BrokenBarrierException ex) {
            return;
        }
    }
}
