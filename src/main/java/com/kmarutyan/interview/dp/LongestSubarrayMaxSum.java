package com.kmarutyan.interview.dp;


public class LongestSubarrayMaxSum {


    public static int longestSubarray(int [] nums){
        int ans = 0;
        int n = nums.length;
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];
        int curMax = nums[0];


        for(int i = 1; i < n; i++){
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(curMax, max);
        }

        return max;

    }

    public static void main(String [] args){
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(longestSubarray(arr));
    }
}
