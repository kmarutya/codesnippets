package com.kmarutyan.interview.dp;

import java.util.Arrays;

public class CoinChange {

    public static int ways(int n, int [] coins){
        Arrays.sort(coins);
        int [][] memo = new int[n+1][coins.length];
        for(int [] ints: memo)
         Arrays.fill(ints, -1);
        return changeWays(n, coins,coins.length-1, memo);

    }
    public static int changeWays(int n, int [] coins, int maxIndex, int [][] memo) {
//        System.out.println(String.format(">>> Sum = %d, max index = %d  ",n, maxIndex));
        if(maxIndex < 0)
            return 0;
        if(n==0)
            return 1;
        if(n < 0)
            return 0;
        if(memo[n][maxIndex] >=0)
            return memo[n][maxIndex];


        int ways = 0;
        for(int i = maxIndex; i >=0; i-- ){
            int maxCoin = coins[maxIndex];
             ways =  changeWays(n-maxCoin, coins, maxIndex, memo)
                    + changeWays(n, coins,maxIndex-1, memo );
        }

        memo[n][maxIndex] = ways;
        return ways;
    }
    public static void main(String... args) throws InterruptedException {

       System.out.println(ways(100, new int[]{1,5,10,25}));
//        System.out.println(ways(10, new int[]{1,5}));

    }
}
