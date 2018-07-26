package com.kmarutyan.interview.string;

import java.util.Arrays;

public class URLify {

    public static String toUrl(String str){
        if(str == null || str.isEmpty())
            throw new RuntimeException("Illegal argument exception");
        char[]chars = str.toCharArray();
        int emptyCounts = 0;
        int nonEmtpyCounts = 0;
        for( char c : chars){
            if(c == ' ')
                emptyCounts++;
            else
                nonEmtpyCounts++;
        }
        int index = nonEmtpyCounts + 3*emptyCounts;
        int initLength = chars.length;
        chars = Arrays.copyOf(chars, index);
        for(int i = initLength-1; i >= 0; i--){
            if(chars[i] == ' '){
                chars[index-1] = '0';
                chars[index-2] = '2';
                chars[index-3] = '%';
                index = index - 3;
            }
            else{
                chars[index-1] = chars[i];
                index = index -1;
            }
            System.out.println(new String(chars));
        }

        return new String(chars);
    }


    public static void main(String [] args){

        System.out.println(toUrl("I want you to be happy on the 8th of March"));
    }
}
