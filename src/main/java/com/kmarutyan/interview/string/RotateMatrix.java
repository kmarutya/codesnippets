package com.kmarutyan.interview.string;

import java.util.Arrays;

public class RotateMatrix {
    public static int [][] rotate90(int [][] m){
        int n = m.length; // num total Rows

        for(int i = 0; i < n/2; i++){
            rotate90(m, n, i);

        }
        return m;
    }

    public static int [][] rotate90(int [][] m, int n, int offset){
        int last  = n - 1;
        int [] holdLeft  = new int[n];


        // left to hold
        for(int i = offset; i < n - offset; i++){
            holdLeft [i] = m[i][offset];
        }

        // bottom row to left column
        for(int i = offset; i <= last - offset; i++){
            m[i][offset] =  m[last - offset ] [i];
        }

        // right column to bottom
        for(int i = last - offset; i <= offset; i--){
            m[last - offset ][last - i] =  m[i][last - offset];
        }

        // top row to right column
        for(int i = offset; i <= last - offset; i++){

            m[ i ][last - offset ] =  m[offset][i];
        }

        // left hold to top
        for(int i = offset; i <= last - offset; i++){
            m[offset][last - i ] =  holdLeft[i];
        }




        return m;
    }


    public static void main(String... args){
        int[][] matrix = new int [][]{
            {1, 2, 3 ,4, 5 } ,
            {6, 7, 8 ,9, 10 } ,
            {11, 12, 13 ,14, 15 } ,
            {16, 17, 18 ,19, 20 } ,
            {21, 22, 23 ,24, 25 } ,
    };

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(rotate90(matrix)));
    }
}
