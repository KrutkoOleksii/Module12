package concurrency;

import java.util.concurrent.CyclicBarrier;

public class Water {

    private static CyclicBarrier barrier;

    public static void main(String[] args) {
        barrier = new CyclicBarrier(3,
                () -> {
                    System.out.print("\n");
                });

        for (int i = 0; i < 10; i++){
            Thread oxygen = new Thread(new Oxygen(barrier),"oxy");
            Thread hydrogen1 = new Thread(new Hydrogen(barrier),"hyd1");
            Thread hydrogen2 = new Thread(new Hydrogen(barrier),"hyd2");
            oxygen.start();
            hydrogen1.start();
            hydrogen2.start();
        }
    }
}


