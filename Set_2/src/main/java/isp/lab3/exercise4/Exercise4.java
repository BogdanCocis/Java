package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint myPoint1 = new MyPoint();
        MyPoint myPoint2 = new MyPoint();
        myPoint1.setXYZ(1, 2, 3);
        myPoint2.setXYZ(3, 4, 5);
        double distance = myPoint1.callDistance(myPoint2);
        System.out.printf("Distance from fist point to second point is: %.2f", distance);
    }
}
