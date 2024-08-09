package exceptions;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {

        int[] ints = new int[5];
        try {
            for (int i = 0; i < 6; i++){
                ints[i] = i;
            }
            for (int i : ints) {
                System.out.println(i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение типа: " + e.getClass());
        }
    }
}
