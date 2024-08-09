package multithreading;

import java.util.Random;

public class Main {
    static Random random = new Random();
    static int randInt = random.nextInt(0, 1_000_000);
    static boolean isWrong = true;

    public static void main(String[] args) {
        Thread human = new Thread(new Runnable() {
            @Override
            public void run() {

                while (isWrong) {
                    int newInt = random.nextInt(0, 1_000_000);
                    System.out.println("Я думаю это: " + newInt);
                    if (newInt == randInt){
                        isWrong = false;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Неизвестная шибка!");
                    }
                }
            }
        });
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (isWrong) {
                    System.out.println("Прошло секунд: " + i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Неизвестная шибка!");
                    }
                }
            }
        });
        System.out.println("Правильный ответ буит: " + randInt);
        timer.start();
        human.start();
    }
}
