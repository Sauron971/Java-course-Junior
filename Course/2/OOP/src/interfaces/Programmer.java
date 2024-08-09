package interfaces;

public class Programmer implements Driver, Worker{
    @Override
    public void drive() {
        System.out.println("Ведет машину!");
    }

    @Override
    public void work() {
        System.out.println("Чухает кнопки");
    }
}
