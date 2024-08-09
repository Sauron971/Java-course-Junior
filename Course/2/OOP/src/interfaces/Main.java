package interfaces;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Waiter waiter = new Waiter() {
            @Override
            public void bringOrder(String nameOfFood) {
                System.out.println("Begy begy c");
                System.out.println(nameOfFood);
            }
        };
        client.makeOrder(waiter, "Huy konya");

    }
}
