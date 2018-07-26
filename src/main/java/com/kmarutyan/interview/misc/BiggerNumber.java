package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiggerNumber {


    public static void biggestNumber(String input){
       List<Long> digits = new ArrayList<>();
       for(Character c: input.toCharArray()){
           long v = Character.getNumericValue(c);
           digits.add(v);
       }
        Collections.sort(digits, Collections.reverseOrder());

       long max = 0;
       for(int i = 0; i < digits.size(); i++){
           max = 10*max + digits.get(i);
       }

        System.out.println(">>>>");
        System.out.println(max);


    }
    public static void main(String [] args){
        String input = "3834834";
        biggestNumber(input);


    }
}
