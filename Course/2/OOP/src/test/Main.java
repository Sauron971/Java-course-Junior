package test;

import example.Person;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(1, 21);
            System.out.println(String.format("Выпало число: %s ", a));
            if ( a == 20) System.out.println("КРИТИЧЕСКАЯ УДАЧА!");
            else if (a == 1) System.out.println("КРИТИЧЕСКАЯ НЕУДАЧА!");
        }
    }
}
