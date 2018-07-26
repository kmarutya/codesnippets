package com.kmarutyan.interview.dp;

import java.util.Arrays;

public class SubsetSum {

    public static boolean subsetSum(int [] ints, int n, int sum){
        //base case
        // Base Cases
        if (sum == 0)
            return true;
        if(ints == null || n == 0)
            return false;

        int last = ints[n-1];
        if( last > sum)
            return subsetSum(ints, n-1, sum);
        else
            return   subsetSum(ints, n-1, sum) || subsetSum(ints, n - 1, sum - last);

    }

    public static void main(String[] args) {
        int [] ints = {3, 34, 4, 12, 5, 2};
        System.out.println(subsetSum(ints, ints.length, 13));

    }
}
