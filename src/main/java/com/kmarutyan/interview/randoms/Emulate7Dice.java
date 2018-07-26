package com.kmarutyan.interview.randoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class   Emulate7Dice {

    public static int rand7(){
        int sum7 = IntStream.range(0, 7).map( l -> six() ).sum();
        return sum7%6 +1;
    }

    static int six(){
        Random  r = new Random();
        return r.nextInt(6)+1;
    }
    public static void main(String [] args){

        Map<Integer, Integer> stats  =  new HashMap<>();
        IntStream.range(0, 1000000).forEach( l-> stats.merge(rand7(), 1, ( a,b )-> a+b) );

        stats.keySet().stream().forEach( k->
                System.out.println(k + " = " +stats.get(k))
        );

    }
}


