package example;

public class Rectangle {
    double length;
    double width;

    void setDimens(double length, double width){
        this.length = length;
        this.width = width;
    }
    double getSquare(){
        return length * width;
    }
}
