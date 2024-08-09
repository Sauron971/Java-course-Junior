package box;

public class Box {
    protected double length;
    protected double width;
    protected double height;

    public Box() {
        this(10);
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Box(double size) {
        this(size, size, size);
    }

    public Box(Box another) {
        this(another.length, another.width, another.height);
    }

    public void setDimens(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int compare(Box another) {
        double currentVolume = getVolume();
        double anotherVolume = another.getVolume();
        if (currentVolume > anotherVolume) {
            return 1;
        } else if (currentVolume < anotherVolume) {
            return -1;
        } else {
            return 0;
        }
    }

    public double getVolume() {
        return length * width * height;
    }

    public void showVolume() {
        System.out.println(getVolume());
    }

    public Box copy() {
        return new Box(length, width, height);
    }

    public Box increase() {
        return new Box(length * 2, width * 2, height * 2);
    }

    public void showInfo() {
        System.out.println("Длина: " + length);
        System.out.println("Щирина: " + width);
        System.out.println("Высота: " + height);
    }
}
