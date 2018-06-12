package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by apple on 6/7/18.
 */
public class ReverseNumber {

    public static int reverseInt(int i){
        int rev = 0;
        // 1356
        while(i > 0){
            rev =  rev*10 + i % 10;
            i = i/10;

        }
         return rev;

    }
    public static void main(String [] args){

        Collection<Integer> ints = Arrays.asList(1356, 84838,33494,34348 );
        for(int i: ints){
            System.out.println(i + " --> "+ reverseInt(i));
        }

    }
}


