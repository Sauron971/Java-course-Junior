package example;

public class Dog {
    String name;
    String breed;
    int weight;
    int speed;
    String getInfo(){
        return "Имя: "+ name + "\n" + "Порода: "+ breed + "\n" + "Вес: "+ weight + "\n";
    }
    void run() {
        for(int i = 0; i<speed; i++) {
            System.out.println("Бегу");
        }
    }
}
