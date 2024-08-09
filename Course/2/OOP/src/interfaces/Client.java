package interfaces;

public class Client {
    public void makeOrder(Waiter waiter, String nameOfFood) {
        waiter.bringOrder(nameOfFood);
    }
}
