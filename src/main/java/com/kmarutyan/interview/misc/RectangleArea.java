package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.List;

public class RectangleArea {

    public static int findArea(List<Point> r1, List<Point>r2){
        int area = 0;
        int area1 = getArea(r1);
        int area2 = getArea(r2);

        int overlap =
                getOverlap(r1.get(0).x,r1.get(1).x, r2.get(0).x,r2.get(1).x) *
                        getOverlap(r1.get(0).y,r1.get(1).y, r2.get(0).y,r2.get(1).y)
                ;

        area = area1 + area2 - overlap;
        return area;


    }
    public static int getOverlap(int x1, int x2, int k1, int k2){
        if(Math.max(x1, x2) < Math.min(k1, k2))
            return 0;
        if(Math.max(k1, k2) < Math.min(x1, x2))
            return 0;

        return Math.min( Math.max( k1, k2), Math.max(x1, x2)) - Math.max( Math.min( k1, k2), Math.min(x1, x2));
    }
    public static int getArea(List<Point> r){
        Point p1 = r.get(0);
        Point p2 = r.get(1);

        int area = Math.abs((p1.x - p2.x) * (p1.y - p2.y));
        return area;
    }

    public static void main(String [] args){
        List<Point> rect1 = Arrays.asList(new Point(-3, 0),    new Point(3, 4));
        List<Point> rect2 = Arrays.asList(new Point(0, -1),    new Point(9, 2));
        System.out.println(findArea(rect1, rect2));

        List rect3 = Arrays.asList(new Point(-3, -3),    new Point(-1, -1));
        List rect4 = Arrays.asList(new Point(2, 2),    new Point(9, 4));
        System.out.println(findArea(rect3, rect4));

    }
}


class Point{
    public Point(){}
    public Point(int x, int y){
        this.x = x ;
        this.y = y;
    }
    int x;
    int y;

}