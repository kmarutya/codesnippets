package com.kmarutyan.interview.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringToInt {

    public static Long strToInt(String str){
        // sanity check
        if(str == null){
            return null;
        }
//        Character [] chars =  str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
//        List<Character>  charList = Arrays.asList(chars);
//        Collections.reverse(charList);
        try{
            long ans = 0l;
            for(char c :str.toCharArray() ){
                int curVal = Character.getNumericValue(c);
                ans = ans*10 + curVal;
            }
             return ans;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String [] args){

        System.out.println( String.format("%s = %d", "9383882", strToInt("9383882")));
    }
}
