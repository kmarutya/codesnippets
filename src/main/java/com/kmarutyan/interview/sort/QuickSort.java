package com.kmarutyan.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 3/25/17.
 */
public class QuickSort {

    public static List<Integer> quickSort(List<Integer> numbers){
        if(numbers.size() < 2)
            return numbers;

        final int pivot = numbers.get(0);
        final List<Integer> lower =  new ArrayList<>();
        final List<Integer> higher =  new ArrayList<>();

        for(int i = 1; i < numbers.size(); i++){
           int val = numbers.get(i);
           if(val <= pivot)
               lower.add(val);
           else
               higher.add(val);
        }
        final List<Integer> sorted =  new ArrayList<Integer>();

        sorted.addAll(quickSort(lower));
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));


        return sorted;

    }


    public static void inPlaceQuickSort(int [] array){
        inPlaceQuickSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.print(i + "->"));
    }
    public static void inPlaceQuickSort(int [] array, int start, int end){
        if(array == null || array.length <=1)
            return; // nothing to do
        if( start >= end)
            return;

        int pivot_pos = partition(array, start, end);
        System.out.println(pivot_pos);
        inPlaceQuickSort(array, start, pivot_pos -1);
        inPlaceQuickSort(array, pivot_pos + 1, end);
    }

    public static int partition(int [] a, int start, int end){
        int pivot = a[start];
        int i = start + 1;

        for(int j = i; j <= end; j++){
            if( a[j] < pivot){
                swap(a, j, i);
                i++;
            }
        }

        swap(a, start, i-1);
        return i-1;
    }
    public static void swap(int [] array, int i, int j ){
        int hold = array[i];
        array[i] = array[j];
        array[j] = hold;
    }

    public static void mergeAndPrint(List<Integer>in){
        for (int i : quickSort(in) ) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    public static void main(String [] args){
//        mergeAndPrint(Arrays.asList(new Integer[]{1,4,3,5,2,13,34,2,5}));
//        mergeAndPrint(Arrays.asList(new Integer[]{1,4,5,3,2,13,34,2,5}));
//        mergeAndPrint(Arrays.asList(new Integer[]{}));
//        mergeAndPrint(Arrays.asList(new Integer[]{5,5}));
//        mergeAndPrint(Arrays.asList(new Integer[]{9,8,7,6,5,4,3,2,1}));


       inPlaceQuickSort(new int[]{1,4,3,5,2,13,34,2,5});


    }
}

