package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.Stack;

public class HappyNumber {

    public static boolean isHappy(int i){
        int next = i;
        for(int iter = 0; iter < 300; iter++){
           int [] digits = getSingleDigits( next ) ;
           next =  Arrays.stream( digits).map(l -> l*l).sum();
           System.out.println(String.format("Next = %s", next));
           if(next == 1)
               return true;

        }


        return false;

    }


    public static int [] getSingleDigits(int i){
        Stack<Integer> ints =  new Stack<>();
        while( true){
           int div = i/10;
           int rem =  i % 10;
           if(div > 0){
               ints.push(rem);
               i = div;
           }
           else{
               ints.push(i);
               break;
           }

        }


        return ints.stream().mapToInt(l -> l).toArray();

    }
    public static void main(String [] args){

        //Arrays.asList(2,4,56,34).forEach(i -> System.out.println( isHappy(i)));
        System.out.println(isHappy(19));
        System.out.println(isHappy(0));


    }
}
