package com.kmarutyan.interview.randoms;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class RandomCalc {

    public static int randomBlacklisted(int N, int [] blacklist ){
        List<Integer> vals = new ArrayList<>();
        List bl = new ArrayList();
        Arrays.stream(blacklist).forEach(a -> bl.add(a));
        for(int i = 0; i <= N; i++ ){
            if(!bl.contains(i)){
                vals.add(i);
            }
        }

        Random r = new Random();
        int ind = r.nextInt(N+1-3);
        if(ind <= 0) ind = vals.size()-1-ind;

        return vals.get(ind);
    }


    public static String randomWeighted( String [] vals, double [] weights){
        Random r = new Random();
        double totalWeight = Arrays.stream(weights).sum();

        double randWeight = totalWeight * r.nextDouble();
        double runningSum = 0;
            for(int i = 0; i < weights.length; i++){
                runningSum += weights[i];
                if(runningSum >= randWeight){
                    return vals[i];
                }
            }

        return "Not Found";
    }

    public static void main(String [] args){

        int N = 21;
        int [] blacklist = {2, 3,5};
//        for (int i = 1; i < 50; i++ ){
//            System.out.print(randomBlacklisted(N, blacklist) + " \t");
//        }

//
//        for(int i = 0 ; i < 30; i++){
//            System.out.print(randomWeighted(new String []{"a", "b", "c"}, new double[] {0.1, 0.2, 0.7})+ "\t");
//
//        }

        Map<String,Integer>counts = new HashMap<>();
        for(int i = 0 ; i < 5000; i++){
            String key = randomWeighted(new String []{"a", "b", "c"}, new double[] {0.1, 0.2, 0.7});
            counts.merge(key, 1, Integer::sum);
        }
        counts.forEach( (k, v) -> System.out.println(String.format("%s -> %d", k, v)));

    }
}
