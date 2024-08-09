import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("cats.txt");

//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        List<Cat> cats = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            cats.add(new Cat("cat" + i, "breed" + i+1, i+5));
//        }
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
//            outputStream.writeObject(cats);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            List<Cat> catList = (List<Cat>) inputStream.readObject();
            catList.forEach(cat -> System.out.println(cat.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}