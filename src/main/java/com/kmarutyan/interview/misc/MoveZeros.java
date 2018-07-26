package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class MoveZeros {

    public static <PrintableToString> void p(PrintableToString... args) {
        for(PrintableToString pts: args)
            System.out.print(pts);
        System.out.println();
    }

    public static int [] minZeros(int [] data){

        int left  = 0;
        int right =  data.length -1;
        while(left< right){
          if( data[left] != 0){
              left++;
              continue;
            }
          else if (data[right] != 0){
              swap(data, left, right);
              left++;
          }
          else{
              right--;
          }

        }

        return data;
    }

    public static void swap(int [] arr, int l, int r){
        // sanity checks
        if (arr == null || arr.length==0){
            //do nothing
            return;
        }
        int hold = arr[r];
        arr[r] = arr[l];
        arr[l] = hold;
    }

    public static void main(String []args){

        int [] data = {1, 2, 0, 3, 0, 1, 2};

        System.out.println(Arrays.toString(minZeros(data)));
        System.out.println(Arrays.toString(minZeros(new int[]   {1,2})));

    }
}
