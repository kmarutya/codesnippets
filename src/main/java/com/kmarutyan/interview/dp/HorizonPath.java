package com.kmarutyan.interview.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HorizonPath {
    static int [][] memoization ;
    public static int minPath(int[][] path){
        int v = path.length;
        int l = path[0].length;
        memoization = new int[v][l];
        for(int i: IntStream.range(0, v).toArray()){
            for( int j: IntStream.range(0,l).toArray()){
                memoization[i][j] = -1;
            }

        }

        // fill-up memoization
        System.arraycopy(path[0] , 0, memoization[0], 0,l);
        return minPath(path, v-1);
    }

    public static int minPath(int[][] path, int v){
        System.out.println(v);
        System.out.println(Arrays.deepToString(memoization));

        int maxH = path[0].length-1;

        for (int curH = 0; curH <= maxH; curH++){
            int left = Math.max(curH - 1, 0);
            int under = curH;
            int right = Math.min(curH + 1, maxH);

            int curVal = path[v][curH];

            if (memoization [v-1][left] <0){
                minPath(path,  v -1);
            }
            int score1 = memoization [v-1][left] + curVal;
            int score2 = memoization [v-1][under] + curVal;
            int score3 = memoization [v-1][right] + curVal;

            int minScore = Math.min(Math.min(score1, score2), score3);
            memoization[v][curH] = minScore;
//            System.out.println(Arrays.deepToString(memoization));

        }

        System.out.println(Arrays.deepToString(memoization));

        return Arrays.stream(memoization[v]).min().getAsInt();
    }
    public static void main(String [] args){
//         int [][] path = new int[][]{
//                 {1,2, 3, 4,5},
//                 {1,3, 3, 4,3},
//                 {2,2, 3, 1,1},
//                 {4,5, 3, 3,1},
//                 {5,3, 2, 4,5},
//                 {3,4, 3, 2,2},
//        };

        int [][] path = new int[][]{
                {1,2, 3, 4,1},
                {1,3, 3, 1,3},
                {2,2, 1, 1,1},
                {4,1, 3, 3,1},
                {1,3, 2, 4,5},
                {3,1, 3, 2,2},
        };


        System.out.println(minPath(path));

    }
}
