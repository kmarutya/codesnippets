package com.kmarutyan.interview.dp;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

public class TripleCase {


    public static int tripleCaseBruteForce(int steps){
        if(steps < 0){
            return 0;
        }
        if(steps == 0){
            return 1;
        }
        return tripleCaseBruteForce(steps-1)+ tripleCaseBruteForce(steps-2) + tripleCaseBruteForce(steps -3);
    }
    public static int tripleCase(int steps){
        int [] memo =  new int[steps+1];
        Arrays.fill(memo, -1);
        return tripleCase(steps, memo);
    }


    public static int tripleCase(int n, int memo[]){
        if(n < 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        else if( memo[n] >-1 ){
            return memo[n];
        }
        else{
            memo[n] =   tripleCase(n-1, memo)
                        + tripleCase(n-2, memo)
                        + tripleCase(n-3, memo);
            return memo[n];
        }
    }

    public static void main(String... args){
        int n = 11;
        System.out.println(String.format("For steps %d there are %d possible solutions", n, tripleCaseBruteForce(n)) );
        System.out.println(String.format("For steps %d there are %d possible solutions", n, tripleCase(n)) );
    }
}
