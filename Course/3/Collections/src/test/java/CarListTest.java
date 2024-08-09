import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private CarList<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList<>(); //init
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementNotRemovedThenSizeNotChange() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException(){

        assertThrows(IndexOutOfBoundsException.class, () -> carList.get(100));
    }

    @Test
    public void methodGetReturnedRightValue(){
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("Supra", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("Supra", carFromList.getBrand());
    }
    @Test
    public void insertIntoStart() {
        Car car = new Car("Supra", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("Supra", carFromList.getBrand());
    }
    @Test
    public void insertIntoEnd() {
        Car car = new Car("Supra", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("Supra", carFromList.getBrand());
    }

    @Test
    public void ifCarContainsCarReturnTrue() {
        Car car = new Car("Brand1", 1);
        Car notCar = new Car("Penis", 115);
        assertTrue(carList.contains(car));
        assertFalse(carList.contains(notCar));
    }
}