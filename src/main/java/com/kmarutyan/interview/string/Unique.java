package com.kmarutyan.interview.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Unique {

    public static boolean isUnique(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars =  str.toCharArray();

        //map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))}
        for(char c: chars){
            int val = map.compute(c,(k, v)-> (v== null)? 1: v+1);
            if(val > 1)
                return false;
        }

        return true;
    }

    public static boolean isUniqueV2(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars =  str.toCharArray();

        //map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))}
        for(char c: chars){
            int val = map.compute(c,(k, v)-> (v== null)? 1: v+1);
            if(val > 1)
                return false;
        }

        return true;
    }




    public static void main(String ... args){
        String [] str = new String []{ "adkld", "sks", "aldoiuy"};
        Arrays.stream(str).forEach(s -> System.out.printf("String '%s' has only unique characters: %s\n" ,s,isUnique(s)));
    }
}
