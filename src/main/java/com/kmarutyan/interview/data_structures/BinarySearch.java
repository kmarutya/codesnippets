package com.kmarutyan.interview.data_structures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearch {


    public static int binarySearch(int [] list , int val){
       if(list.length == 0)
           return -1;
       int l  = 0;
       int r = list.length - 1 ;
       int m = (r-l)/2;
       while(l <= r){
//           System.out.println(String.format("l=%d, r=%d, m = %d", l, r, m));
           if( list[m] == val) {
               return m;
           }
           else if( list[m] > val){
               r = m-1;
           }else{
               l = m+1;
           }
            m = l + (r-l)/2;

       }
       return -1;
    }

    public static void main(String... args){
        int [] data  =  {1,2,4, 6,8,11,12,13,14, 17, 19, 20,22, 24, 25,26,28, 31, 42};
        Arrays.stream(data).boxed().collect(Collectors.toList());
        Arrays.asList(data);

        System.out.println(binarySearch(data, 14));
//        System.out.println("-----");
        System.out.println(binarySearch(data, 16));

    }

}
