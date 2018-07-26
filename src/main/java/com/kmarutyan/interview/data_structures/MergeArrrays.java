package com.kmarutyan.interview.data_structures;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MergeArrrays
{
    public static void merge(int [] a, int indexA, int [] b){
//        int indexA = a.length-1; non-zero values of A
        int indexB = b.length -1;
        int indexC = indexA + b.length -1;

        while( indexB >= 0){
            int valA = a[indexA];
            int valB =  b[indexB];
            if(valB  >= valA){
                a[indexC] = valB;
                indexB--;
            }
            else{
                a[indexC] = valA;
                indexA--;
            }
            indexC--;

        }

    }

    public static void main(String... args){
        Integer [] a = {1,2,4,5,8,9,19,23,24,26, 28,31,44};
        int [] b =  {3, 5, 10,11, 23, 34};
        Integer [] C = Arrays.copyOf(a, a.length + + b.length +10);
        int [] c = Arrays.stream(C).map(i-> (i == null)? -1: i ).mapToInt(i-> (int) i).toArray();
        System.out.println(Arrays.deepToString(C));
        merge(c,  a.length-1, b);
        System.out.println(Arrays.toString(c));


    }
}
