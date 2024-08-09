package interfaces;

public class Bird extends Animal implements AbleToFly, AbleToRun{
    @Override
    public void eat() {
        System.out.println("semechki");
    }

    @Override
    public void fly() {
        System.out.println("Путица летит!");
    }

    @Override
    public void run() {
        System.out.println("Путица летит!");
    }
}
