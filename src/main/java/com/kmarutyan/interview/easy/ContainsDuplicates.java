package com.kmarutyan.interview.easy;

import java.util.*;
import java.util.stream.Collectors;

public class ContainsDuplicates {

    public static boolean containsDuplicates(int [] ints){

        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet(list); //.addAll(list);
        if(ints.length > set.size())
                return true;
        else
                return false;
    }

    public static boolean containsDuplicates2(int [] ints){
        Map<Integer, Integer> counts = new HashMap<>();

        for(Integer i: ints){
            counts.merge(i, 1, Integer::sum);
        }

        for(Integer count:  counts.keySet()){
            if(count > 1)
                return true;
        }

        return false;

    }


    public static void main(String [] args ){
        int [] ints = {1,2,3,1};
        System.out.println(containsDuplicates(ints));
        System.out.println(containsDuplicates2(ints));

    }
}
