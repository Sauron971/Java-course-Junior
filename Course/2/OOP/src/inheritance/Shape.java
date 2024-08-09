package inheritance;

public abstract class Shape {
    private int a;
    private int b;



    public Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract int getPerimeter();

    public final void showPerimeter() {
        System.out.println(getPerimeter());
    }

    public final int getA() {
        return a;
    }

    public final int getB() {
        return b;
    }
}
