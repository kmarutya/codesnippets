package com.kmarutyan.interview.string;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {


    public static boolean check(String str){

        char [] chars = str.replaceAll("\\s+","").toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(Character c: chars){
            map.compute(c, (key,value)->(value == null)? 1 : value+1 );
        }


        int numOdds = 0;
        for(int i: map.values()){
            if(i%2 == 1) {
                numOdds++;
            }
            if(numOdds > 1)
                return false;
        }

        return true;
    }

    public static void main(String... args){
        System.out.println(check( "Tact Coa"));
    }
}
