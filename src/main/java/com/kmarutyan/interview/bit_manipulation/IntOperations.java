package com.kmarutyan.interview.bit_manipulation;

import java.util.Arrays;

public class IntOperations {

    public static int negation(int a){
        if(a == 0)
            return 0;
        int sign = (a > 0)? 1 : -1;
        int neg = 0;
        while(a != 0){
            if(a > 0) {
                a--;
                neg--;
            }
            else{
                a++;
                neg++;
            }
        }

        return neg;

    }


    public static void main(String...args){


        Arrays.asList(-1, 0, 4).stream().forEach(i-> System.out.println(negation(i)));
    }
}
