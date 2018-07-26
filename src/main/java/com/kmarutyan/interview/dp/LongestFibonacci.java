package com.kmarutyan.interview.dp;

import java.util.*;

public class LongestFibonacci {



    public static int findLongest(int [] data){
        Set<Integer> s = new HashSet<>();
        for(int i: data) s.add(i);
        int max = data.length;

        int maxLength = 0;
        for(int i = 0; i < max; i++){
            for(int j = i + 1; j < max; j++){
                int ai = data[i];
                int aj = data[j];
                int candidate = ai + aj;
               // System.out.println( max + ": "+ i + " " +j  + " candidate = "+ candidate);

                int runningMaxLength = 2;
                while(s.contains(candidate)){
                    runningMaxLength++;
                    ai = aj;
                    aj = candidate;
                    candidate = ai + aj;
                    //System.out.println(String.format("Max(%d, %d)", maxLength, runningMaxLength));
                    maxLength = Math.max(maxLength, runningMaxLength);
                }
            }
        }

        return maxLength;

    }

    public static int findLongestDP(int [] data){
        // find longest Fibonacci-like sequence using dynamic programming
        int n = data.length;
        Map<Integer, Integer> index = new HashMap();
        for(int i = 0; i<n; i++) {
            index.put(data[i], i);
        }

        int [][] dp = new int[n][n];
        int maxLength = 0;

        for (int k = 0; k < n ; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(data[k] - data[j], -1);
                if (i >= 0 && i < j) {
                    int cand = (dp[i][j] > 2 ? dp[i][j] : 2) + 1;
                    dp[j][k] = cand;
                    maxLength = Math.max(maxLength, cand);
                }
            }

        return (maxLength > 2)? maxLength: -1;

    }

    public static void main(String [] args){
        int [] data = new int[]{1,2,3,4,5,6,7,8, 13,14, 15, 16, 21};
//        System.out.println(findLongest(data));
        System.out.println(findLongestDP(data));


    }
}
