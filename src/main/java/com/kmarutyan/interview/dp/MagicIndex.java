package com.kmarutyan.interview.dp;

public class MagicIndex {


    public static Integer findMagicIndex(int [] ints){
        // sanity check
        if(ints == null || ints.length ==0){
            return -1;
        }
        return findMagicIndex(ints, 0, ints.length -1);

    }
    public static Integer findMagicIndex(int [] ints, int left, int right){

        if(left > right){
            return -1;
        }
        int mid = (left + right)/2;
        if( ints[mid] == mid){
            return mid;
        }
        else if (ints[mid] > mid){
            return findMagicIndex(ints, left, mid - 1);
        }
        else{
            return findMagicIndex(ints, mid+1, right);
        }

    }

    public static void main(String... args){
        int [] ints =  {-4, -3, -0, 3, 4, 6, 12, 123,124, 125, 126, 127};
        System.out.println(findMagicIndex(ints));

    }
}
