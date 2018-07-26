package com.kmarutyan.interview.misc;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static boolean isIsomorphic(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() != s2.length())
                return false;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < chars1.length; i++){
            Character c1 = chars1[i];
            Character c2 = chars2[i];
            if( map.get(c1) == null){
                map.put(c1, c2);
            }
            else if(map.get(c1)!= c2){
                return false;
            }
        }

    return true;

    }

    public static void main(String [] args){
        System.out.println( isIsomorphic("egg", "add"));
        System.out.println( isIsomorphic("foo", "bar"));
        System.out.println( isIsomorphic("paper", "title"));

    }
}
