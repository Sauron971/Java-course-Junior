package inheritance;

public class Triangle extends Shape {
    private int c;

    public Triangle(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public int getPerimeter() {
        return c + super.getA() + super.getB() ;
    }
}
