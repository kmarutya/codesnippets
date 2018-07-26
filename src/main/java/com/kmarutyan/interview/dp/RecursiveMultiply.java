package com.kmarutyan.interview.dp;

import java.util.Arrays;

public class RecursiveMultiply {
    public static int recursiveMultiply(int a, int b){
        if(a == 0 || b == 0)
            return 0;
        if(a == 1)
            return b;
        if(b == 1)
            return a;

        int max = Math.max(a,b );
        int min = Math.min(a,b);
        int sum = max +  recursiveMultiply(min-1, max);

        return sum;

    }

    public static int recursiveMultiply2(int a, int b){
        if(a == 0 || b == 0)
            return 0;
        if(a == 1)
            return b;
        if(b == 1)
            return a;

        int max = Math.max(a,b );
        int min = Math.min(a,b);
        int s1 = min >>1;
        int sum = 2 * ( max +  recursiveMultiply2(s1-1, max));

        if(min%2 ==1)
            sum = sum + max;

        return sum;

    }

    public static int recursiveMultiply3(int a, int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int [] memo = new int[ min + 1];
        Arrays.fill(memo, -1);
        return recursiveMultiply3Helper(min, max, memo);
    }

    public static int recursiveMultiply3Helper(int a, int b, int [] memo){
        if(a == 0 || b == 0)
            return 0;
        if(a == 1)
            return b;
        if(b == 1)
            return a;
        if(memo[a] >= 0)
            return  memo[a];

        int max = Math.max(a,b );
        int min = Math.min(a,b);
        int s1 = min >>1;
        int sum = 2 * ( max +  recursiveMultiply2(s1-1, max));
        if(min%2 ==1)
            sum = sum + max;
        memo[a] = sum;

        return sum;
    }


    public static void main(String... args){

        System.out.println(recursiveMultiply3(7, 8));
    }
}
