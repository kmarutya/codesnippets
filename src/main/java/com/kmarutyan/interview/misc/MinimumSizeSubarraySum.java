package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSizeSubarraySum {
    public static int [] minSubarray(int [] nums, int s){
        List<Integer> ans = new ArrayList<>();


        int [] hold = Arrays.copyOf(nums, nums.length);
        int iter=1;

        while(iter <= nums.length){
            for(int i = 0; i< nums.length-1; i++){
                int val = hold[i];
                if(val >=s){
                    return Arrays.copyOfRange(nums,i,i+iter );
                }
                hold[i]=hold[i] + hold[i+1];
            }
            iter++;

        }



        return new int[]{};

    }
    public static void main(String... args){
        int [] nums = {2,3,1,2,4,3};

        System.out.println(Arrays.toString(minSubarray(nums, 7)));
    }
}
