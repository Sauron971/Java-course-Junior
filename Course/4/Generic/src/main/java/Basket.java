import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {
    ArrayList<T> array = new ArrayList<>();

    public double getWeight() {
        double s = 0;
        for (T element : array) {
            s += element.getWeight();
        }
        return s;
    }

    public void add(T elemnt) {
        array.add(elemnt);
    }

    public int compare(Basket<? extends Fruit> anotherBasket) {
        if (getWeight() > anotherBasket.getWeight()) {
            return 1;
        } else if (getWeight() == anotherBasket.getWeight()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static  <U> void transfer(List<? extends U> src, List<? super U> dst) {
        dst.addAll(src);
        src.clear();
    }
}
