package com.kmarutyan.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by apple on 7/25/18.
 */
public class CoinSum {
    //1, 3, 4
    public static int findSumSolution(int sum) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0, 0);
        dp.add(1, 1);
        dp.add(2, 1);
        dp.add(3, 2);
        dp.add(4, 4);


        for (int i = 5; i <= sum; i++) {
            int val = dp.get(i - 1) + dp.get(i - 3) + dp.get(i - 4);
            dp.add(i, val);
        }

        return dp.get(sum);

    }

    public static int findNumSolution(int sum, List<Integer> coins){
        if(sum <= 0)
            return 0;
        if(coins.contains(sum)){
            List<Integer> modifiedCoinSet = coins.stream().filter(i -> i!=sum).collect(Collectors.toList());
            int addAnws = findNumSolution(sum  , modifiedCoinSet);
            return 1 + addAnws;
        }

        int ans = 0;
        for(int i = 0; i < coins.size(); i++){
            int curSum = findNumSolution(sum - coins.get(i), coins);
            if(curSum > 0){
                ans += curSum;
            }

        }
        return ans;
    }

    public static int[] memoization;
    public static int findNumSolutionWithMemoization(int sum, List<Integer> coins){
        if(sum <= 0)
            return 0;
        if(memoization[sum] > 0)
            return memoization[sum];

        if(coins.contains(sum)){
            List<Integer> modifiedCoinSet = coins.stream().filter(i -> i!=sum).collect(Collectors.toList());
            int addAnws = findNumSolution(sum  , modifiedCoinSet);
            return 1 + addAnws;
        }

        int ans = 0;
        for(int i = 0; i < coins.size(); i++){
            int curSum = findNumSolution(sum - coins.get(i), coins);
            memoization[i] = curSum;
            if(curSum > 0){
                ans += curSum;
            }

        }
        return ans;
    }

    public static int findWithMemo(int sum, int [] coins){
        int [] memo = new int[sum+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return findWithMemo(sum, coins, memo);
    }
    public static int findWithMemo(int sum, int [] coins, int [] memo){
        if(sum < 0)
            return 0;

        if(memo[sum]>=0)
            return memo[sum];

        int ans = 0;
        for (int coin: coins){
           int localAns =  findWithMemo(sum - coin, coins, memo);
           if(localAns >0)
                ans += localAns;
        }
        memo[sum] = ans;

        return ans;
    }
    public static void main(String args[]){
//        System.out.println(String.format("N ways for sum %d:= %d",5,findSumSolution(5)));
      //  System.out.println(String.format("Nways for sum %d:= %d",6,findSumSolution(6)));

        List<Integer> coins =  Arrays.asList(1,3,4);
        coins.stream().mapToInt(i->i).toArray();

//        int i = 4; System.out.println(String.format("N ways for sum %d:= %d",i,findNumSolution(i, coins)));
//        int i=3;
//       System.out.println(String.format("N ways for sum %d:= %d",1,findWithMemo(i,coins.stream().mapToInt(l->l).toArray())));


        for(int i = 1; i <= 20; i++){
            memoization  = new int[i+1];
            Arrays.fill(memoization, -1);
//            System.out.println(String.format("N ways for sum %d:= %d",i,findSumSolution(i)));
//            System.out.println(String.format("N ways for sum %d:= %d",i,findNumSolution(i, coins)));
//            System.out.println(String.format("N ways for sum %d:= %d",i,findNumSolutionWithMemoization(i, coins)));
            System.out.println(String.format("N ways for sum %d:= %d",i,findWithMemo(i,coins.stream().mapToInt(l->l).toArray())));


        }
    }
}
