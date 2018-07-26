package com.kmarutyan.interview.misc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSize {

    public static List<Integer> getPondSize(int [][] pond){
        List<Integer> pondSizes = new ArrayList<>();
        int rows  = pond.length;
        int cols = pond[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++) {
                if (pond[r][c] != 0) {
                    pond[r][c] = -1;
                }
            }
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                // either an island or already visited
                if(pond[r][c] != 0){
                    continue;
                }
                int size =  getSize(pond, r,c);
                pondSizes.add(size);

            }
        }
        System.out.println(      Arrays.deepToString(pond));


        System.out.println(pondSizes);
        return pondSizes;

    }

    public static int getSize(int [][] pond, int r, int c){
        int size = 1;
        int rows  = pond.length;
        int cols = pond[0].length;
        if(pond[r][c] !=0)
            return 0;

        pond[r][c] = 1;
        for(int rc =  Math.max(0, r -1 ); rc <= Math.min(rows-1, r+1); rc++){
            for(int cc =  Math.max(0, c -1 ); cc <= Math.min(cols -1, c+1); cc++){
//                System.out.println(String.format("(%d, %d) = %d", rc, cc, size));
                size += getSize(pond, rc, cc);
            }
        }
        return size;
    }
    public static void main(String... args){
        int [][] pond = {
                {1, 2, 0, 0,2},
                {0, 4 ,3, 0,3},
                {0, 4 ,0, 1,3},
                {3, 4 ,3, 0,2},
                {0, 0 ,3, 0,3},
        };
        System.out.println(      Arrays.deepToString(pond));

        System.out.println(getPondSize(pond));
    }
}
