package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class ArrayPermutations {



    public static int[][] permutate(int[][] in){
        if(in.length == 1){
            int out [][] =  new int [in[0].length][1];
            for(int i = 0; i < in[0].length; i++){
                out[i][0] = in[0][i];
            }
            return out;
        }
        int [][] o1 = Arrays.copyOfRange(in, 0,  in.length - 1);
        int [][] o2 = Arrays.copyOfRange(in, in.length - 1,  in.length );
        int [][] out = merge(permutate(o1), o2);

        return out;
    }

    public static int[][] merge(int [][] o1, int[][] o2){
        int totalSize = o1.length * o2[0].length;
        int [][] out = new int [totalSize][];

        for(int i = 0; i < o1.length; i++){

            for(int k = 0; k < o2[0].length; k++){
                int tmp [] = new int[o1[i].length + 1];
                System.arraycopy(o1[i], 0, tmp, 0, o1[i].length);
                tmp[tmp.length-1] = o2[0][k];

                int index = k*o1.length + i;
                out[k*o1.length + i] = tmp;
            }
        }

        System.out.println("o1 array = " +Arrays.deepToString(o1));
        System.out.println("o2 array = " +Arrays.deepToString(o2));
        System.out.println("Out array = " +Arrays.deepToString(out));

        return out;

    }


    public static void main(String [] args){
        int [][] arrays = {
                {1, 2, 3}
                ,
                {4},
                {5,6}
        };

        int [][] out =  permutate(arrays);

        System.out.println(">>>>>>>>>");
        System.out.println(Arrays.deepToString(out));

    }
}
