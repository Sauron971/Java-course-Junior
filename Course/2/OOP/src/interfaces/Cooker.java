package interfaces;

public class Cooker implements Driver, Worker{
    @Override
    public void drive() {
        System.out.println("Ведет машину!");
    }

    @Override
    public void work() {
        System.out.println("Чухает яички");
    }
}
