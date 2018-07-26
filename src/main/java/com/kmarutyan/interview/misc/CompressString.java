package com.kmarutyan.interview.misc;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompressString {

    public static String decompress(String str, int pos, int times){

        System.out.println(String.format("%s pos = %d times=%d", str, pos, times));
        char[] chars = str.toCharArray();
        char c = chars[pos];
        if(c =='['){
            decompress(str, ++pos, times);
        }

        if(c ==']'){
            String token = "";
            for(int i = 0; i< times; i++){
                token = token + str;

            }
            return str + decompress(str, ++pos, times);
        }

        if(Character.isDigit(c)){
            String loop  = "";
            while(pos < str.length()){
                c = str.charAt(pos);
                if(Character.isDigit(c)){
                    loop = loop + c;
                    pos++;
                }
                else
                    break;
            }
            return decompress(str, pos, times*Integer.valueOf(loop));
        }

        else {
            String curStr = "";
            while(pos < str.length()){
                c = str.charAt(pos);
                if(Character.isLetter(c)){
                    curStr = curStr + c;
                    pos++ ;
                }
                else
                    break;
            }
            String token = "";
            for(int i = 0; i< times; i++){
                token = token + str;

            }
            return token ;
        }


    }

    public static String decompress2(String s){
        // delete white spaces
        s = s.replaceAll(" ", "");

        Stack<String> stack = new Stack<String>();
        char[] arr = s.toCharArray();

        StringBuilder sb =  new StringBuilder();
        StringBuilder dsb =  new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                sb.append(arr[i]);
            }
            else if (!Character.isLetter(arr[i])){
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
            }

            if (Character.isDigit(arr[i])) {
                dsb.append(arr[i]);
            }
            else if (!Character.isDigit(arr[i])) {
                if (dsb.length() > 0) {
                    stack.push(dsb.toString());
                    dsb = new StringBuilder();
                }
            }

           if(arr[i] == '['){
                stack.push("[");
            }

           if(arr[i] == ']'){
                String combine = "";
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (top.equals("[")) {
                        break;
                    } else {
                        combine = top + combine ;
                    }
                }

                if(stack.isEmpty()){
                    stack.push(combine) ;
                }

               int times =  Integer.valueOf(stack.pop());
                String token = "";
                for(int m = 0; m < times; m++){
                    token = token + combine;
                }
               stack.push(token) ;

            }

        }

        StringBuilder out = new StringBuilder();
        while(!stack.isEmpty()){
            out.append(stack.pop());
        }

        return out.toString();
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static void main(String args[]){
        String compressed = "2[3[a]b]";
       //System.out.println(decompress2(compressed));
      System.out.println(decompress2("3[abc]4[ab]c"));



    }
}
