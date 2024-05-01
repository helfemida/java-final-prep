package practice_1.solutions;

import java.util.*;

class MyPoint {
    double x, y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String res = "(" + this.x + "," + this.y + ")";
        return res;
    }

    public double distance(MyPoint point) {
        double dis = Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
        return dis;
    }

    public MyPoint closest(MyPoint[] points) {
        MyPoint res = points[0];
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {

            if (Math.sqrt(Math.pow((this.x - points[i].x), 2) + Math.pow((this.y - points[i].y), 2)) < min) {
                min = Math.sqrt(Math.pow((this.x - points[i].x), 2) + Math.pow((this.y - points[i].y), 2));
                res = points[i];
            }
        }
        return res;
    }

}

class PointsMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MyPoint point = new MyPoint();

        MyPoint[] points = new MyPoint[6];
        for (int i = 0; i < 6; i++) {
            points[i] = new MyPoint(in.nextDouble(), in.nextDouble());
        }

        MyPoint closest = point.closest(points);
        System.out.println("Closest point to " + point.toString() + " is " + closest.toString() + ". Their distance is " + point.distance(closest) + ".");
    }
}
