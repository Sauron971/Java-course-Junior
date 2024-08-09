import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    @Test
    void testAddAppleBasket() {
        Basket<Apple> appleBasket = new Basket<>();
        Apple apple = new Apple(100);
        appleBasket.add(apple);
        assertEquals(1, appleBasket.array.size(), "Apple basket should contain 1 apple");
    }

    @Test
    void testAddOrangeBasket() {
        Basket<Orange> orangeBasket = new Basket<>();
        Orange orange = new Orange(200);
        orangeBasket.add(orange);
        assertEquals(1, orangeBasket.array.size(), "Orange basket should contain 1 orange");
    }

    @Test
    void testAddFruitBasket() {
        Basket<Fruit> fruitBasket = new Basket<>();
        Apple apple = new Apple(100);
        Orange orange = new Orange(200);
        fruitBasket.add(apple);
        fruitBasket.add(orange);
        assertEquals(2, fruitBasket.array.size(), "Fruit basket should contain 1 apple and 1 orange");
    }

    @Test
    void testTransfer() {
        Basket<Apple> srcBasket = new Basket<>();
        srcBasket.add(new Apple(100));
        srcBasket.add(new Apple(200));
        Basket<Fruit> dstBasket = new Basket<>();
        Basket.transfer(srcBasket.array, dstBasket.array);
        assertEquals(0, srcBasket.array.size(), "Source basket should be empty");
        assertEquals(2, dstBasket.array.size(), "Destination basket should have 2 items");
        assertEquals(300, dstBasket.getWeight(), "Weight should be 300");
    }
    @Test
    void testCompare() {
        Basket<Fruit> basket1 = new Basket<>();
        basket1.add(new Apple(100)); // Общий вес: 100
        basket1.add(new Orange(200)); // Общий вес: 300

        Basket<Fruit> basket2 = new Basket<>();
        basket2.add(new Apple(150)); // Общий вес: 150
        basket2.add(new Orange(250)); // Общий вес: 400

        assertEquals(-1, basket1.compare(basket2), "Basket1 should be smaller than Basket2");
        assertEquals(1, basket2.compare(basket1), "Basket2 should be larger than Basket1");
        assertEquals(0, basket1.compare(basket1), "Basket1 should be equal to itself");
    }
}