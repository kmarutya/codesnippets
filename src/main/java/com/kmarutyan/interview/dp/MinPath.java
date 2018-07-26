package com.kmarutyan.interview.dp;

/**
 * Created by apple on 7/26/18.
 */
public class MinPath {


    public static int minPath(int [][] m){
        int v = m.length-1;
        int h = m[0].length-1;
        return minPath(m, v,h);
    }

    public static int minPath(int [][] m, int v, int h){
        int score = 0;
        // base  case
        if(h==0 && v ==0){
            return m[0][0];
        }

        int pathA  = (v ==0)? Integer.MAX_VALUE :  minPath(m, v-1, h);
        int pathB  = (h ==0)? Integer.MAX_VALUE :  minPath(m, v, h-1);
        score = m[v][h] + Math.min(pathA,pathB)  ;

        System.out.println(String.format("m [%d][%d] = %d", v, h, score));
        return score;
    }

    public static void main(String [] args){
        int [][] matrix= new int [][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(minPath(matrix));
    }
}
