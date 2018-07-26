package com.kmarutyan.interview.misc;

import java.util.*;

public class MissingInt {

    public static int missingInt(int [] ints){
        int def = 1;

        ///sanity check
        if (ints ==  null ||  ints.length == 0)
                return def;

        Comparator<Integer>  intComp = (Integer i1, Integer i2) -> i1.compareTo(i2);
        Arrays.sort(ints);

        int left = 0;
        int right = ints.length - 1;
        int middle = (right - left)/2;

        while(left < right){
            if(middle == ints[middle] -1){
                left = middle + 1;
                middle =  (right + left )/2;
            }
            else{
                right = middle;
                middle = (right + left )/2;
            }

        }
      //  System.out.println(">>" + middle);
        if(middle == 0){
            return 1;
        }
        else if(middle == ints.length - 1){
            return middle + 2;
        }
        else{
            return middle + 1;
        }

    }

//
//    public static int [] removeDuplicates(int[] ints){
//       // sanity check
//        if(ints == null || ints.length == 0)
//            return ints;
//
//    }

    public static void main(String [] args){

        System.out.println(missingInt(null));
        System.out.println(missingInt(new int []{ 2}));
        System.out.println(missingInt(new int []{1, 2}));
        System.out.println(missingInt(new int []{1, 2, 3, 4, 6, 7}));
        System.out.println(missingInt(new int []{1, 2, 3, 4, 5, 6, 7}));


    }
}
