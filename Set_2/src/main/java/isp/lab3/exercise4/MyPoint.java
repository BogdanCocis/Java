package isp.lab3.exercise4;

public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int callDistance(int x, int y, int z) {
        int distanceX = this.x - x;
        int distanceY = this.y - y;
        int distanceZ = this.z - z;
        int distance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
        return distance;
    }

    public double callDistance(MyPoint another){
        int distanceX = this.x - another.getX();
        int distanceY = this.y - another.getY();
        int distanceZ = this.z - another.getZ();
        return  ((double) Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ));
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
