package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class Sum2 {

    public static boolean sum2(int sum, int [] data){
        if (data == null || data.length == 0){
            return false;
        }
        Arrays.sort(data);
        int l = 0;
        int r = data.length -1;
        while(l<= r){
            int curSum = data[l] + data[r];
            println(String.format("current (%d + %d) = %d,  l = %d, r = %d", data[l], data[r],curSum, l, r));

            if(curSum == sum){
                return true;
            }
            else if(curSum > sum){
                r-=1;
            }
            else{
                l+=1;
            }
        }

        return false;
    }

//    public static boolean sum3(int sum, int [] data){
//
//    }
    public static void println(Object obj){
        System.out.println(obj.toString());

    }

    public static void main(String []args){
        int [] data = {1,3, 34, 234,23,23,12};

        println(sum2(16, data));


    }
}
