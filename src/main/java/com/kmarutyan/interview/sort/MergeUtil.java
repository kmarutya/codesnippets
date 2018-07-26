package com.kmarutyan.interview;

/**
 * Created by apple on 8/4/17.
 */

public class  MergeUtil {

        public static void main(String [] args){

        int[] A = new int[] {1, 3, 5, 7, 9, 12, 15, 20, 21, 23};
        int[] B = new int[] {2, 3, 7, 8, 10, 14, 18, 24, 100};

      //  int [] merged = merge(A, B);



    }
    // will you call back?
    // Hi, sorry, the phone connection is broken :( yes calling back

    public static int[] merge(int [] right, int [] left){

        int [] merged  = new int [left.length + right.length];
        int lp = 0;
        int rp = 0;
        int mp = 0;

        while(lp < left.length  && rp < right.length){
            int l  = left[lp];
            int r  = right[rp];

            if (l < r){
                merged[lp + rp] = l;
                lp +=1;
            }
            if (r < l){
                merged[lp + rp] = r;
                rp +=1;
            }

        }

        while(lp < left.length){
            int l = left[lp];
            merged[lp + rp] = l;
            lp +=1   ;

        }
        while(rp < right.length){
            int r = right[rp];
            merged[lp + rp] = r;
            rp +=1  ;

        }

        return merged;

    }

}




