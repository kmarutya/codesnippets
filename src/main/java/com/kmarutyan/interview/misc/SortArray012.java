package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class SortArray012 {


    public static int[] sortArray(int [] ints){

        // sanity check
        if(ints == null || ints.length == 0)
                return ints;

        int l = 0;
        int h = ints.length -1;
        int m = 0;

        while(m <= h){
//            System.out.println(Arrays.deepToString(Arrays.stream(ints).boxed().toArray()));
//            System.out.println(String.format( "low = %d,  mid = %d, high = %d", l,m, h ));
//            System.out.println();
            switch(ints[m]){

                case 0:{
                    swap(ints, l, m);
                    m++;
                    l++;
                    break;
                }
                case 1:{
                    m++;
                    break;
                }
                case 2:{
                    swap(ints,m, h);
                    h--;
                    break;
                }

            }
        }

        return ints;
    }

    public static void swap(int [] arr, int i, int j){
        int hold = arr[i];
        arr[i] = arr[j];
        arr[j] = hold;
    }

    public static void main(String [] args){
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.deepToString(Arrays.stream(sortArray(arr)).boxed().toArray()));
    }
}
