package com.kmarutyan.interview.misc;

/**
 * Created by apple on 6/11/18.
 */
public class IsPefectNumber {

    public static boolean isPerfectNumber(int i){

        int holdVal = 1;
        int runningSum = 0;
        while(holdVal <= i/2){
            runningSum = (i % holdVal == 0)? runningSum + holdVal : runningSum;

//            System.out.println("holdVal: " +  holdVal);
//            System.out.println("runningSum: " +  runningSum);
            holdVal++;

        }

        boolean isPerfect = (runningSum == i)? true :  false;

        return isPerfect;

    }
    public static void main(String [] args){
        int [] ints  = { 6, 3 , 211 , 28, 33, 496};

        for(int i: ints){
            System.out.println(String.format("Is %d a perfect number? Answer is: %b", i, isPerfectNumber(i)));
        }
    }
}
