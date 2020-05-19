package com.kmarutyan.interview.dp;

public class LongestIncreasingSubsequence {
    static int totalMax = 0; // stores the LIS


    public static int lis(int [] data){
        int n = data.length;
        return lis(data, n);
    }
    public static int lis(int [] data, int n){
        int l = 0;
        if( n == 1)
            return 1;

        int curMax = 1;
        /* Recursively get all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */
        for (int i = 1; i < n; i++)
        {
            int maxI = lis(data, i);
            if (data[i-1] < data[n-1])
                curMax = Math.max(curMax, maxI + 1);
        }
        totalMax = Math.max(curMax, totalMax);

        return curMax;
    }

    public static void main(String[] args){
        System.out.println(lis(new int []{  0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 }));
    }
}
