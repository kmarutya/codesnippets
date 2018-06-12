package com.kmarutyan.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 3/25/17.
 */
public class QuickSort {

    public static List<Integer> quickSort(List<Integer> numbers){
        if(numbers.size() < 2) return numbers;

        final int pivot = numbers.get(0);
        final List<Integer> lower =  new ArrayList<>();
        final List<Integer> higher =  new ArrayList<>();
        for(int i = 1; i < numbers.size(); i++){
           int val = numbers.get(i);
           if(val <= pivot)  lower.add(val);
           else higher.add(val);
        }
        final List<Integer> sorted =  new ArrayList<Integer>();

        sorted.addAll(quickSort(lower));
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));


        return sorted;

    }

    public static void mergeAndPrint(List<Integer>in){
        for (int i : quickSort(in) ) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    public static void main(String [] args){
        mergeAndPrint(Arrays.asList(new Integer[]{1,4,3,5,2,13,34,2,5}));
        mergeAndPrint(Arrays.asList(new Integer[]{1,4,5,3,2,13,34,2,5}));
        mergeAndPrint(Arrays.asList(new Integer[]{}));
        mergeAndPrint(Arrays.asList(new Integer[]{5,5}));
        mergeAndPrint(Arrays.asList(new Integer[]{9,8,7,6,5,4,3,2,1}));


        System.out.println(5 & 5);

        System.out.println(1/2);


    }
}

