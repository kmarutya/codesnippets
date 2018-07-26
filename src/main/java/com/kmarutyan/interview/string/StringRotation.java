package com.kmarutyan.interview.string;

import java.util.Arrays;
import java.util.List;

public class StringRotation {

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public static boolean isRotation(String s1, String s2){
        boolean ans = true;
        String composite= new StringBuilder(s2).append(s2).toString();
        return composite.contains(s1);
    }
    public static void main (String... args){
        List <String> strList1 = Arrays.asList(new String[]{"a", "ab"});
        List <String> strList2= Arrays.asList(new String[]{"b", "abab"});

        for (int i = 0; i < strList1.size(); i++ ){
            String s1 = strList1.get(i);
            String s2 = strList2.get(i);
            System.out.println(String.format("String %s is a substring of %s %s ",s1, s2, isRotation(s1, s2)));
        }




    }
}
