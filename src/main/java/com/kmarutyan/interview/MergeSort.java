package com.kmarutyan.interview;

/**
 * Created by apple on 3/25/17.
 */
public class MergeSort {

    public static int [] mergeSort(int [] in){
        if(in == null) throw new IllegalArgumentException("Null array is given as an input");
        if(in.length <=1) return in;

        int middle = in.length/2;
        int [] left = new int [middle];
        int [] right = new int[in.length - middle];

        System.arraycopy(in, 0, left, 0, left.length);
        System.arraycopy(in, middle, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int [] merge(int [] left, int [] right){
        int [] merged = new int [left.length + right.length];
        int leftPoint = 0;
        int rightPoint = 0;
        int mergedtPoint = 0;


        while(leftPoint < left.length && rightPoint < right.length){
            int l = left[leftPoint];
            int r = right[rightPoint];
            if(l < r) {
                merged[leftPoint + rightPoint] = l;
                leftPoint +=1;
            }
            else {
                merged[leftPoint + rightPoint] = r;
                rightPoint +=1;
            }
        }
         while(leftPoint < left.length){
             int l = left[leftPoint];
             merged[leftPoint + rightPoint] = l;
             leftPoint +=1;

         }
         while(rightPoint < right.length){
            int r = right[rightPoint];
            merged[leftPoint + rightPoint] = r;
             rightPoint +=1;

        }
        return merged;

    }

    public static void mergeAndPrint(int [] in){
        for (int i : mergeSort(in) ) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String [] args){

        mergeAndPrint(new int[] {3,4,5,1,5,3,2,9,0,5,6});
        mergeAndPrint(new int[] {3});
        mergeAndPrint(new int[] {4, 3});
        mergeAndPrint(new int[] {3, 4});
        mergeAndPrint(new int[] {3, 4,5,6,7 });
        mergeAndPrint(new int[] {9,8,7,6,5,4,3,2,1,0 });

    }
}
