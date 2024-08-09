package example;

public class Worker {
    String name;
    String duty;
    int paycheck;

    Worker (String name, String duty, int paycheck) {
        this.duty = duty;
        this.paycheck = paycheck;
        this.name = name;
    }

    void showInfo() {
        System.out.println(name + " " + duty + " " + paycheck);
    }
}
