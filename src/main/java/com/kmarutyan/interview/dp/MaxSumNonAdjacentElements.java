package com.kmarutyan.interview.dp;

public class MaxSumNonAdjacentElements {
    Integer [] memoization ;

    public MaxSumNonAdjacentElements(int [] data){
        memoization = new Integer[data.length];
    }

    public   int maxSum(int [] data, int pos){
        System.out.println(String.format("Position %d", pos));
        if(pos <= 0)
            return 0;
        if(pos == 1)
            return data[0];
//        if(memoization[pos] != null)
//            return memoization[pos];

        Integer maxP1 = maxSum(data, pos-1);
        Integer maxP2 = maxSum(data, pos-2) + data[pos];
        memoization[pos] =  Math.max(maxP1, maxP2);

        return memoization[pos];

    }

    public static void main(String [] args){
        int data [] =  { 1, 0, 3, 9, 2 };
        System.out.println(new MaxSumNonAdjacentElements(data).maxSum(data, data.length -1));
        data =  new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(new MaxSumNonAdjacentElements(data).maxSum(data, data.length -1));

    }
}
