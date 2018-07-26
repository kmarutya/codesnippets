package com.kmarutyan.interview.misc;

import java.util.Stack;

public class ReverseString {

    public static String reverseString(String str){
        char[] chars = str.toCharArray();
        Stack <Character>stack  = new Stack<>();
        for(char c: chars)
            stack.push(c);

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }

    public static String reverseString2(String str){
        char[] chars = str.toCharArray();

        for(int i = 0; i <    chars.length /2; i++ ){
            char hold = chars[i];
            int ri = chars.length - 1 -i;
            chars[i] = chars[ri];
            chars[ri] = hold;
        }

        return new String(chars);
    }

    public static String reverseWords(String str){
        char[] chars = str.toCharArray();

        int l =0 ,r = chars.length-1;
        while(l <= r){
            System.out.println(String.format("l = %d, r = %d, word = %s",l, r, new String(chars)));
            char cl = chars[l];
            char cr = chars[r];
            char hold = cr;
            chars[r] = cl;
            chars[l] = hold;
            l++;
            r--;

        }


        return new String(chars);
    }

    public static void main(String[] args) {

//        System.out.println(reverseString("abcdefg"));
//        System.out.println(reverseString2("abcdefg"));
//        System.out.println(reverseString2("abcdefge"));
//        System.out.println(reverseString2("a"));
//        System.out.println(reverseString2("ab"));
//        System.out.println(reverseString2("abc"));

        System.out.println(reverseWords("rof gnikool era uoy em ti si olleH"));

        }
}
