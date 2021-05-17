package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Oxygen implements Runnable {
    private final CyclicBarrier cyclicBarrier;

    Oxygen(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void releaseOxygen(){
        System.out.print("O");
    }

    public void run() {
        try {
            cyclicBarrier.await();
            releaseOxygen();
        } catch (InterruptedException ex) {
            return;
        } catch (BrokenBarrierException ex) {
            return;
        }
    }
}