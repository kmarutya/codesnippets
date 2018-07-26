package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class SubArrayWithGivenSum {


    public static void findSubarray(int [] data, int sum ){
        if(data == null || data.length <= 0 || sum <= 0) {
            return;
        }

        int start = 0;
        int end = 0;
        int runningSum = 0;

        while(end < data.length){
            runningSum+=data[end];
//            System.out.println(String.format("%d , %d,  %d", start, end, runningSum));
             if (runningSum == sum){
                 // print result and start over
                 System.out.println(String.format("Subarray (%d , %d) sums up to %d" , start, end,runningSum));
                 start = start + 1;
                 end = start;
             }
             else if(runningSum > sum){

                 // reset and start over from the next index to start;
                 runningSum = 0;
                 start = start + 1;
                 end = start;
            }
            else{
                end++;
             }

        }


    }
    public static void main(String [] args) {

        findSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 12);
        findSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15);

    }
}
