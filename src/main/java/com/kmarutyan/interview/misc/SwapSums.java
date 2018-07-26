package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class SwapSums {

    // a-b = (sumA-sumB)/2
    public static int []  findSwapIndex(int [] a, int []b){
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        if((sumA-sumB)%2 != 0)
            return null;
        int target = (sumA-sumB)/2;
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        while(i < a.length -1  && j < b.length -1){
            int diff = a[i] - b[j];
            if(diff == target){
                return new int []{a[i],b[j]};
            }
            else if (diff < target){
                i++;
            }
            else{
                j++;
            }
        }




        return null;
    }


    public static void main(String[] args) {
        int [] a = {4,1,2,1,1,2};
        int [] b = {3,6,3,3};
        System.out.println(Arrays.toString(findSwapIndex(a,b)));
    }
}
