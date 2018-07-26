package com.kmarutyan.interview.string;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Permutations {

    public static boolean isPermutations(String s1, String s2){
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();

        s1.toLowerCase().chars().mapToObj(c -> (char)c).forEach(k->m1.compute(k,(key,val) -> (val == null)? 1: val+1 ));
        s2.toLowerCase().chars().mapToObj(c -> (char)c).forEach(k->m2.compute(k,(key,val) -> (val == null)? 1: val+1 ));

        for(Character key : m1.keySet()){
            if(!m2.containsKey(key))
                return false;
            if(m1.get(key) != m2.get(key))
                return false;
            m2.remove(key);
        }
        return m2.isEmpty();

    }
    public static void main(String... args){
        String s1 = "opa";
        String s2 = "oap";
        System.out.println(String.format("String %s is permutation of a string %s ?: %s ",s1, s2, isPermutations(s1,s2)  ));


       s1 = "opa";
       s2 = "oapp";
       System.out.println(String.format("String %s is permutation of a string %s ?: %s ",s1, s2, isPermutations(s1,s2)  ));

        s1 = "opa";
        s2 = "opa";
        System.out.println(String.format("String %s is permutation of a string %s ?: %s ",s1, s2, isPermutations(s1,s2)  ));

        s1 = "opa";
        s2 = "opA";
        System.out.println(String.format("String %s is permutation of a string %s ?: %s ",s1, s2, isPermutations(s1,s2)  ));

    }
}
