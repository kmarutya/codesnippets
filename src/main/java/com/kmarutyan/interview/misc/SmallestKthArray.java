package com.kmarutyan.interview.misc;

import java.util.*;

public class SmallestKthArray {

    public static int [] kthMin(int [] arrays, int k){
        if(k<=0)
            return new int[0];
        if(arrays == null || arrays.length < k)
            return new int [0];

        Queue<Integer> heap = new PriorityQueue<>((i,j) -> i-j);
        List<Integer> list = new ArrayList<>();

        for(int i: arrays){
            heap.offer(i);
        }

        for(int i = 0; i<5; i++){
            list.add(heap.poll());
        }
        return list.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        int [] array = new int []{12,23,45,5,32,83,23,42, 343,34,24,55,51, 20, 939,8383,3838,83,14,31};
        System.out.println(Arrays.toString(kthMin(array, 5)));
    }
}
