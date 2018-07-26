package com.kmarutyan.interview.dp;

import java.util.Arrays;

public class MaxIncreasingSubsequence {


    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int curMax = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curMax = dp[j];
                }
            }

            dp[i] = curMax + 1;
        }
       // Arrays.stream(dp).forEach(System.out::println);
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String [] args){
        int[] data = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(data));


    }
}
