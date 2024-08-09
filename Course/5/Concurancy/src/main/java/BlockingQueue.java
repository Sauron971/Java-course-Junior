import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    Queue<Runnable> queue = new LinkedList<>();
    final Object monitor = new Object();

    public void add(Runnable r) {
        synchronized (monitor) {
            queue.add(r);
            monitor.notify();
        }
    }

    public Runnable take() {
        synchronized (monitor) {
            try {
                while (queue.isEmpty()) {
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return queue.poll();
        }
    }
}
