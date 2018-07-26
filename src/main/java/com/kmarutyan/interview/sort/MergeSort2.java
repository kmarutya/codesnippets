package com.kmarutyan.interview.sort;

import java.util.Arrays;

public class MergeSort2 {

    public static int [] sort(int [] arr){
        // sanity checks
        if (arr == null || arr.length < 2)
            return arr;

        int [] half1 = Arrays.copyOfRange(arr, 0, arr.length/2);
        int [] half2 =  Arrays.copyOfRange(arr, arr.length/2, arr.length);
        return merge(sort(half1), sort( half2));

    }

    public static int []  merge(int [] arr1, int [] arr2){
        int dim1 = arr1.length;
        int dim2 = arr2.length;
        int [] ans = new int [dim1 + dim2];

        int i = 0;
        int j = 0;
        int ind = 0;

        while(i < dim1 && j < dim2 ){
            int vi = arr1[i];
            int vj = arr2 [j];
            if(vi < vj){
                ans[ind ] = vi;
                i++;
                ind++;
            }
            else{
                ans[ind] = vj;
                j++;
                ind++;
            }
        }

        while(i < dim1){
            ans[ind] = arr1[i];
            i++;
            ind++;
        }

        while(j < dim2){
            ans[ind] = arr2[j];
            j++;
            ind++;
         }
        return ans;

    }

    public static void main(String [] args){
        System.out.println(Arrays.deepToString(Arrays.stream(sort(new int [ ]{ 3,4,5,1,5,3,2,9,0,5,6})).boxed().toArray()));
    }
}
