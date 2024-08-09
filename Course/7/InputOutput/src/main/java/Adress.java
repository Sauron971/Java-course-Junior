import java.io.Serializable;

public class Adress implements Serializable {
    private String street;
    private int numberOfHouse;

    public Adress(String street, int numberOfHouse) {
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", numberOfHouse=" + numberOfHouse +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }
}
