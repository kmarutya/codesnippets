package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EggDrop {
    public static final int numFloors = 100;
    int minDrops = Integer.MAX_VALUE;


    public  int minDrops( ){
       return IntStream.rangeClosed(0, 100).map(i -> minDrops(i, 1, 0)).min().getAsInt();
    }
    public static int minDrops(int floor, int drops, int num_broken){
        if (floor == numFloors){
            return drops;
        }
        if(floor == numFloors -1){
            return drops + 1;
        }

        if(num_broken == 0){
            int nextFloor = floor + (numFloors - floor) / 2;
            return minDrops(nextFloor ,drops+1, num_broken);
        }else {
           return drops + (numFloors - floor)/2;
        }
    }



    public static void main(String [] args){
        EggDrop e = new EggDrop();
        System.out.println(e.minDrops(50, 1, 0));
//        System.out.println(e.minDrops());



    }
}
