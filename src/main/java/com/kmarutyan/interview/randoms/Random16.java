package com.kmarutyan.interview.randoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class Random16 {

    public static int random21(){
        return new Random().nextInt(21) + 1;
    }

    public static int random16(){
        while(true){
            int r = random21();
            if(r <= 16)
                return r;

        }
    }


    public static int random16_ver2(){
      int sum = IntStream.range(1, 17).map(l -> random21()).reduce(0, (x, y) -> x + y);
      return sum%16;
    }

    public static void main(String [] args){
        Map<Integer, Integer> stats  =  new HashMap<>();

        IntStream.range(0, 100000).forEach(
                i -> {
                    int key = random16_ver2();
                    stats.merge(key,1, Integer::sum);
                }
        );

        stats.forEach((k,v ) -> System.out.println(k + ": " +stats.get(k)));

    }

}
