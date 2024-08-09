import java.util.TreeMap;

public class Account { // в данном класе происходит взаимная блокировка, то есть каждый поток будет ждать когда освободится монитор
    private int amount1;
    private int amount2;

    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    public Account(int amount1, int amount2) {
        this.amount1 = amount1;
        this.amount2 = amount2;
    }
    public void transferFrom1To2(int amount) {
        synchronized (mon1) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (amount <= amount1) {
                System.out.println("amount <= amount1");
                synchronized (mon2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    amount1 -= amount;
                    amount2 += amount;
                }
            } else {
                System.out.println("Недостаточно средств");
            }
        }
    }
    public void transferFrom2To1(int amount) {
        synchronized (mon2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (amount <= amount2) {
                System.out.println("amount <= amount2");
                synchronized (mon1) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    amount1 += amount;
                    amount2 -= amount;
                }
            } else {
                System.out.println("Недостаточно средств");
            }
        }
    }
}
