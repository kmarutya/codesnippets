package com.kmarutyan.interview.misc;

public class MaxRectangleMatrix {
    public static int maxRectangle(int [][] m){
        int v = m.length;
        int h = m[0].length;


        return 0;
    }

    public static void main(String [] args ){

        int m[][] =
                { {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.print("Area of maximum rectangle is " +
                maxRectangle(m));
    }
}
