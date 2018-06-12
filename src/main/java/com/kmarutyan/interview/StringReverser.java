package com.kmarutyan.interview;

import java.util.Arrays;
import java.util.stream.Collector;

/**
 * Created by apple on 3/25/17.
 */
public class StringReverser {

    public String reverse(String in){

        Object [] words = Arrays.stream(reverseWord(in).split("\\W")).map(w-> reverseWord(w)).toArray();
        StringBuffer sb = new StringBuffer();
        for (Object o : words) {
            sb.append(o.toString()).append(" ");

        }

        return sb.toString().trim();
    }

    public String reverseWord(String in){
        if(in == null){
            throw new RuntimeException("Illegal input (null String)");
        }
        char[] chars = in.toCharArray();
        int size = chars.length;
        if (size < 2){
            return in;
        }
        for(int i = 0; i <= (size -1 -i)  ; i= i + 1){
            int rightPos =  (size - 1) - i;
            Character curLeft = chars[i];
            Character curRight =  chars[rightPos];
            chars[i]   = curRight;
            chars[rightPos]   = curLeft;
        }

        return new String(chars);
    }

    public static void main(String [] args){
        String inStr = "I love all of you";

        StringReverser sr = new StringReverser();
        System.out.println(sr.reverse(inStr));
        System.out.println(sr.reverse(""));
        System.out.println(sr.reverse("A"));
        System.out.println(sr.reverse("AB"));




    }
}



