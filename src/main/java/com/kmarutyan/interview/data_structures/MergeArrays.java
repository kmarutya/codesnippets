package com.kmarutyan.interview.data_structures;

import java.util.Arrays;

public class MergeArrays {
    public static int [] merge(int [] a, int [] b){
        int indexA = 0;
        int indexB = 0;
        int indexAMax = a.length-1;
        int indexBMax = b.length-1;
        int indexC = indexA + indexB;
        int[] c = new int[a.length + b.length];

        while( indexB <= indexBMax && indexA <= indexAMax){
            int valA = a[indexA];
            int valB = b[indexB];
            if(valB  <= valA){
                c[indexC] = valB;
                indexB++;
            }
            else{
                c[indexC] = valA;
                indexA++;
            }
            indexC++;
        }
        if(indexA <= indexAMax){
            c[indexC] = a[indexA];
            indexA++;
            indexC++;
        }
        if(indexB <= indexBMax){
            c[indexC] = a[indexB];
            indexB++;
            indexC++;
        }

        return c;
    }

    public static void main(String... args){
        int [] a = {1,2,4,5,8,9,19,23,24,26, 28,31,44};
        int [] b =  {3, 5, 10,11, 23, 34};
        int [] c = merge(a, b);
        System.out.printf("Merging arrays (a and b):\na = %s\nb=%s\nc=%3$s" ,
                Arrays.toString(a),
                Arrays.toString(b),
                Arrays.toString(c));

    }
}
