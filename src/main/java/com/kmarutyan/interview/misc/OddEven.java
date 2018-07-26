package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class OddEven {

    public static int [] sort(int [] arr){
        int [] ans = new int[arr.length];
        TreeSet<Integer> odds = new TreeSet<>();
        TreeSet<Integer> evens = new TreeSet<>();

        for(int i: arr){
            if(i%2 == 1 ){
                odds.add(i);
            }
            else{
                evens.add(i);
            }

        }

        int ei = ( odds.first() < evens.first()) ? 1: 0;
        int oi = (ei==0)? 1:0;

        // merge

        while(!odds.isEmpty() && !evens.isEmpty()){
            ans[oi] = odds.pollFirst();
            oi = oi + 2;
            ans[ei] = evens.pollFirst();
            ei = ei +2 ;
        }

        if(odds.isEmpty() && !evens.isEmpty()){
            ans[ei] = evens.pollFirst();
            ei = ei + 1 ;
        }
        if(!odds.isEmpty() && evens.isEmpty()){
            ans[oi] = odds.pollFirst();
            oi = oi + 1 ;
        }

        return ans;

    }

    public static void main(String... args){
        int [] arr = {1, 3, 2, 5, 4, 7, 10};
//        Arrays.stream(sort(arr)). forEach(l-> System.out.println(l));


        arr  = new int[]{9, 8, 13, 2, 19, 14};
        Arrays.stream(sort(arr)). forEach(l-> System.out.println(l));


    }
}
