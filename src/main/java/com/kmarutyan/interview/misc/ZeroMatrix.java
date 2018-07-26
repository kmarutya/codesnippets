package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class ZeroMatrix {

    public static int [][] zeroMatrix(int [][] nums){
        int rc = nums.length;
        int cc = nums[0].length;
        int [] zeroRowInd  = new int[rc];
        int [] zeroColInd = new int[cc];
        Arrays.fill(zeroRowInd, 1);
        Arrays.fill(zeroColInd, 1);
        for( int r = 0; r < rc ; r ++){
           for(int c = 0; c < cc; c++){
               if(nums[r][c]== 0){
                   zeroRowInd[r] = 0;
                   zeroColInd[c] = 0;
               }
           }
        }
//        System.out.println(Arrays.toString(zeroRowInd));
//        System.out.println(Arrays.toString(zeroColInd));
        for( int r = 0; r < rc ; r ++){
            for(int c = 0; c < cc; c++){
                if(zeroRowInd[r] == 0 || zeroColInd[c] ==0){
                    nums[r][c] = 0;
                }

            }
        }
        for( int r = 0; r < rc ; r ++){
            System.out.println(Arrays.toString(nums[r]));
        }

        return nums;
    }
    public static void main(String... args){
        int [][] nums = {
                {1,2, 3,4, 5, 5, 2,21},
                {1,2, 3,4, 5, 5,2,21},
                {1,2, 3,4, 5, 5,2,21},
                {1,2, 3,4, 5, 5,0,21},
                {1,2, 3,4, 5, 5,2,21},
                {1,2, 3,4, 5, 5,2,21},
                {1,2, 3,4, 5, 5,2,21},
                {1,0, 3,4, 5, 0,2,21},
                {1,2, 3,4, 5, 5,2,21}
        };

        zeroMatrix(nums);

    }

}
