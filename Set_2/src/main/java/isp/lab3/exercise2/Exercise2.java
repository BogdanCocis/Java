package isp.lab3.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,7,"Green");
        System.out.println("Rectangle with perimeter = "+ rectangle.getPerimeter()+ " and area is = "+ rectangle.getArea());
        System.out.println("Rectangle color is "+rectangle.getColor()+ " with length "+ rectangle.getLength()+ " and width "+rectangle.getWidth());
    }
}
