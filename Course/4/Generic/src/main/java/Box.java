import java.util.List;

public class Box<T extends Number> {
    private T[] array;

    public Box(T... array) {
        this.array = array;
    }
    public double average() {
        double result = 0;
        for (T element : array) {
            result += ((Number) element).doubleValue();
        }
        return result / array.length;
    }
    public static <U> void transfer(List<? extends U> src, List<? super U> dst) {
        dst.addAll(src);
        src.clear();
    }

    public int compare(Box<?> another) {
        if (average()>another.average()) {
            return 1;
        } else if (average()== another.average()) {
            return 0;
        } else {
            return -1;
        }

    }
    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
