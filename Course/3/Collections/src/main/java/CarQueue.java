import java.util.Collection;

public interface CarQueue<T> extends CarCollection<T> {

    boolean add(T car);

    T peak();

    T poll();
}
