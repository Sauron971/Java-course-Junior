package example;

public class Monster {
    int countOfEyes;
    int countOfHands;
    int countOfLegs;

    Monster(int countOfEyes, int countOfHands, int countOfLegs) {
        this.countOfEyes = countOfEyes;
        this.countOfHands = countOfHands;
        this.countOfLegs = countOfLegs;
    }
    Monster(int countOfELF) {
        this(countOfELF, countOfELF, countOfELF);
    }
    Monster() {
        this(2);
    }

    void voice() {
        this.voice(1);
    }
    void voice(int count) {
        this.voice(count, "Grrrrrrr...");
    }
    void voice(int count, String word){
        for(int i = 0; i < count; i++) {
            System.out.println(word + "...");
        }
    }

}
