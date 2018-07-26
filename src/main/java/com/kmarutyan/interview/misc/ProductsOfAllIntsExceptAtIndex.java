package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class ProductsOfAllIntsExceptAtIndex {

    public static int[] getProductsOfAllIntsExceptAtIndex(int [] ints){
        int [] anws = new int[ints.length];

        for (int i = 0; i < ints.length; i++ ){
            int mul = 1;
            for (int j = 0; j < ints.length; j++){
                if(j != i)
                    mul*=ints[j];
            }
            anws[i] = mul;
        }


        return anws;
    }
    public static void main(String [] args){
        int [] ints = {1, 7, 3, 4};

        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(ints)));
    }
}
