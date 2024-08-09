import java.util.Objects;

public class Car implements Comparable<Car> {
    private String brand;
    private int numberOfCar;

    public Car(String brand, int numberOfCar) {
        this.brand = brand;
        this.numberOfCar = numberOfCar;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberOfCar == car.numberOfCar && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, numberOfCar);
    }

    @Override
    public int compareTo(Car o) {
        return brand.compareTo(o.brand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", numberOfCar=" + numberOfCar +
                '}';
    }
}
