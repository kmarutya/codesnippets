package com.kmarutyan.interview.misc;

import java.util.*;
import java.util.stream.IntStream;

public class KthMultiplier {

    public static long kthMultiplier(long k){
        if(k<=0) return 0;
        Queue<Long>  queue = new PriorityQueue<>();
        queue.add(3l);
        long val = 0;
        for(int i = 0; i<k; i++){
            addMultipliers( queue);
            val = queue.poll();
        }
        return val;
    }
    public static void addMultipliers( Queue<Long> queue){
        Long val = queue.peek();
        queue.add(val*3);
        queue.add(val*5);
        queue.add(val*7);
    }

    public static void main(String[] args) {
        System.out.println(kthMultiplier(8));
    }
}
