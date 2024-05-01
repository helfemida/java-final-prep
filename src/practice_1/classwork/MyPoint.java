package practice_1.classwork;

import java.util.InputMismatchException;
import java.util.*;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double distance(int x, int y) {
        double xDif = Math.pow((this.x - x), 2);
        double yDif = Math.pow((this.y - y), 2);

        double dis = Math.sqrt((xDif + yDif));

        return dis;
    }

    public double distance() {
        double xDif = Math.pow((this.x), 2);
        double yDif = Math.pow((this.y), 2);

        double dis = Math.sqrt((xDif + yDif));

        return dis;
    }

    public double distance(MyPoint another) {
        double xDif = Math.pow((this.x - another.getX()), 2);
        double yDif = Math.pow((this.y - another.getY()), 2);

        double dis = Math.sqrt((xDif + yDif));

        return dis;
    }

}

 class TestPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean b = true;
        MyPoint myPoint = null;
        int n = 0, m = 0;
        do {
            try {
                n = scan.nextInt();
                m = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        } while (b);
        scan.close();
        myPoint = new MyPoint(n, m);
        System.out.println(myPoint.distance());

    }
}