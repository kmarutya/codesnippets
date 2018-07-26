package com.kmarutyan.interview.dp;

import java.util.*;

public class UglyNumber {

   static int [] multipliers = {2,3,5};

    public static int nextUglyNumber(int n){
        int curUgly = 1;
        TreeSet<Integer> pool = new TreeSet<Integer>();

        while( n > 0 ){
            System.out.println(String.format("Current ugly %s", curUgly));
            System.out.println(pool.size());
            for(int i: multipliers){
                pool.add( i * curUgly );
            }
            curUgly = pool.pollFirst();
            --n;
        }
        return curUgly;

    }


//   public static findMin(int multip)


    public static void main(String [] args){

        System.out.println(nextUglyNumber(150));
    }
}
