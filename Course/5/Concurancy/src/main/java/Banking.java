public class Banking {

    private int money;

    public Banking(int money) {
        this.money = money;
    }
    public synchronized void outMoney(String name, int money) {
        System.out.println(name + " подошел к банкомату.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (money <= this.money) {
            this.money -= money;
            System.out.println(name + " вывел " + money + " рублей. В банкомате осталось " + this.money + " рублей.");
        } else {
            System.out.println("В банкомате недостаточно денег для " + name);
        }
    }
}
