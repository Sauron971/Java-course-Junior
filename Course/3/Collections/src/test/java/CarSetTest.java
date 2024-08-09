import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet<Car> carSet;

    @BeforeEach
    void setUp(){
        carSet = new CarHashSet<>();  //init
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void whenAdded100ThenSizeMustBe100() {
        assertEquals(100, carSet.size());
    }

    @Test
    void whenAddedEqualCarThenReturnFalse(){
        Car car = new Car("Brand1", 1);
        assertFalse(carSet.add(car));
    }

    @Test
    void whenRemoveThenSizeMustBe99() {
        assertTrue(carSet.remove(new Car("Brand1", 1)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand1", 1)));
        assertEquals(99, carSet.size());
    }

    @Test
    void whenClearThenSizeMustBe0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    void ifCarContainsCarReturnTrue() {
        Car car = new Car("Brand1", 1);
        Car notCar = new Car("Penis", 115);
        assertTrue(carSet.contains(car));
        assertFalse(carSet.contains(notCar));
    }
}