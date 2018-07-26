package com.kmarutyan.interview.divide_and_conquer;

import java.util.Arrays;

public class FindElemInSortedArray {


    // presuming arr is sorted
    public static Integer findElem(int[] arr){
        if(arr == null || arr.length %2 == 0)
            return -1;


        return findElem(arr, 0, arr.length -1 );
    }

    public static Integer findElem(int[] arr, int start, int end){
//        System.out.println(String.format(" Start %d, end %d", start, end));

        // check left
        int lcount = 0;
        for (int i = Math.max(0, start -1 ); i <= Math.min(arr.length -1, start+1 ); i++ ){
            if(arr[i] == arr[start])
                lcount++;
        }
        if(lcount == 1)
            return arr[start];

        int rcount = 0;
        for (int i = Math.max(0, end -1 ); i <= Math.min(arr.length -1, end+1 ); i++ ){
            if(arr[i] == arr[end])
                rcount++;
        }
        if(rcount == 1)
            return arr[end];

        if(start == end)
            return null;


        int mid = start + (end - start)/2;

        // check left side
        Integer left = findElem(arr, start, mid );
        if(left != null)
            return left;

        // check right side
        Integer right = findElem(arr, mid+1, end );
        if(right != null)
            return right;

        else return null;

    }

    public static int findElemXOR(int [] arr){
        int ans = Arrays.stream(arr).boxed().reduce(0, (n1,n2) -> n1 ^ n2  );
        return ans;
    }

    public static void main(String [] args){

        System.out.println(
                findElem(new int [] {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65})
        );
        System.out.println(
                findElem(new int [] {1, 2, 2, 3, 3, 4, 4, 50, 50, 65, 65})
        );

        System.out.println(
                findElem(new int [] { 65, 65, 88})
        );

        System.out.println(
                findElemXOR(new int [] {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65})
        );
        System.out.println(
                findElemXOR(new int [] {1, 2, 2, 3, 3, 4, 4, 50, 50, 65, 65})
        );

        System.out.println(
                findElemXOR(new int [] { 65, 65, 88})
        );
    }
}



