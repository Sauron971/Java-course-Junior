package interfaces;

public class Dog extends Animal implements AbleToRun{
    @Override
    public void eat() {
        System.out.println("pedigri");
    }

    @Override
    public void run(){
        System.out.println("Собака бежит!");
    }
}
