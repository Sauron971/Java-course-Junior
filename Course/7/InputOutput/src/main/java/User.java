import java.io.Serializable;

public class User extends Person implements Serializable {
    private int age;
    private Adress adress;

    public User(String name, String lastName, int age, Adress adress) {
        super(name, lastName);
        System.out.println("constructor");
        this.age = age;
        this.adress = adress;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", adress=" + adress +
                '}';
    }
}
