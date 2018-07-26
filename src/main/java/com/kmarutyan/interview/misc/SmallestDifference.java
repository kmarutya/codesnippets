package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SmallestDifference {

    public static int smallestDiff(int [] i1, int [] i2){
        Arrays.sort(i1);
        Arrays.sort(i2);

        int a = 0,b = 0;
        int diff = Integer.MAX_VALUE;
        while(a < i1.length && b < i2.length ){
            int v1 = i1[a];
            int v2 = i2[b];
            diff = Math.min(diff,  Math.abs(v1 -v2));
            //System.out.println(String.format("v1 = %d, v2 = %d, diff = %d",v1, v2, diff));

            if(v1 > v2)
                b++;
            else
                a++;
        }

        return diff;
    }

    public static void main(String [] args){
        int [] i1 = {1,3,15,11, 2};
        int [] i2 = {23, 127, 235, 19, 9};

        System.out.println(smallestDiff(i1, i2));

     }
}
