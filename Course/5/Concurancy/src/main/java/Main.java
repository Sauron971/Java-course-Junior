import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        CyclicBarrier cb = new CyclicBarrier(10);
        Semaphore sem = new Semaphore(3);
        CountDownLatch downLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " начал подготовку.");
                    try {
                        Thread.sleep(rand.nextInt(1000, 5000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(name + " закончил подготовку.");
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }

                    long timeBefore = System.currentTimeMillis();
                    //---------------------------------------------------------
                    System.out.println(name + " начал первый участок дороги.");
                    try {
                        Thread.sleep(rand.nextInt(500, 2000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(name + " закончил первый участок дороги.");
                    //---------------------------------------------------------

                    try {
                        sem.acquire();
                        System.out.println(name + " заехал в тонель.");
                        Thread.sleep(rand.nextInt(500, 1000));
                        System.out.println(name + " выехал из тонеля.");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        sem.release();
                    }

                    //---------------------------------------------------------
                    System.out.println(name + " начал третий участок дороги.");
                    try {
                        Thread.sleep(rand.nextInt(500, 2000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(name + " закончил третий участок дороги.");
                    //---------------------------------------------------------
                    long timeAfter = System.currentTimeMillis();
                    downLatch.countDown();
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(name + " - " + (timeAfter-timeBefore));
                }
            });
            thread.setName(String.valueOf(i));
            thread.start();
        }
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Победитель: ");
    }
}

