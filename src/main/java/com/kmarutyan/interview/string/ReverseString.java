package com.kmarutyan.interview.string;

public class ReverseString {
    public static String reverse(String str){
        int size = str.length();
        int mid = size/2;
        for(int i= 0; i<mid; i++){
            str = swap(str, i, size -1- i);
        }
        return str;
    }
    public static String swap(String str, int idx1, int idx2){
        char[] chars = str.toCharArray();
        char tmp = chars[idx1];
        chars[idx1] = chars[idx2];
        chars[idx2] = tmp;
        return String.valueOf(chars);
    }

    public static void main(String... args){
        String [] testStrings = {
                "abc",
                "abcd",
                "abcdf"
        };
        for(String s: testStrings)
        {
            System.out.printf("Reverse str=%s is str=%s\n"  ,s, reverse(s));
        }

    }
}


