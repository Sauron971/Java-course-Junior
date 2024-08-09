import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private volatile AtomicInteger value; // Атомик типы обрабатывают операции за одно действие поэтому их не надо синхронизировать
    // volatile запрещает кэшировать эту переменную
    public void inc() {
        value.getAndIncrement();
    }
    public void dec() {
        value.getAndDecrement();
    }
    public int getValue() {
        return value.intValue();
    }
}
