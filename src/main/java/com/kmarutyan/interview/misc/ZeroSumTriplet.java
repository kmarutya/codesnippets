package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class ZeroSumTriplet {

    public static boolean isZeroTriplet(int [] ints){
        boolean ans = false;
        int [] pos = Arrays.stream(ints).filter(i -> i >=0).toArray();
        int [] neg = Arrays.stream(ints).filter(i -> i< 0).toArray();

        Arrays.sort(pos);
        Arrays.sort(neg);

//        for(int)

        return false;
    }

    public static int pivot(int left, int right){
        if(left - right > 0){
            throw new RuntimeException("Wrong params");
        }
        if(right - left == 1)
            return left;
        else{
            return (right - left)/2;
        }
    }
    public static boolean distinct(int left, int pivot, int right){
        if(left == pivot)
            return false;
        if(right == pivot)
            return false;
        if(right == left)
            return false;
        else
            return true;
    }

    public static boolean isTripletSum(int[] ints,int sum){
        int i = 0;
        int j =  ints.length - 1;
        int k = i+1;

        if(!distinct(i,k,j))
            return false;

        while(distinct(i,k,j)){
            int curSum = ints[i] + ints[k] + ints[j];
            if(curSum == sum)
                return true;
            else if(curSum > sum)
                j--;
            else if(k - i > 1)
                i++;
            else{
                k++;
            }

        }
        return false;
    }
    public static boolean isPairSum(int[] ints,int sum){
        int i = 0;
        int j =  ints.length - 1;

        while(i < j){
            int curSum = ints[i] + ints[j];
            if(curSum == sum)
                return true;
            else if(curSum > sum)
                j--;
            else
                i++;

        }
        return false;
    }
    public static void main(String... args){
        int [] ints  =  new int[]{0, -1, 2, -3, 1};
        System.out.println(isTripletSum(ints, 0));
    }
}
