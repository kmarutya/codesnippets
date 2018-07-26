package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.List;

public class ParsingKeyVals {

    public static void parse(String str){
     int start = str.indexOf("{");
     int stop  = str.lastIndexOf("}");

    List<Character>  stack = new ArrayList<>();
    char [] chars = str.substring(start + 1, stop).toCharArray();
     String key = null;
     String val = null;

     for(int i = 0; i < chars.length; i++){

        if(!stack.isEmpty() && chars[i] != '"'){
            stack.add(chars[i]);
        }
        else if(stack.isEmpty()  &&  chars[i] == '"'){
            stack.add(chars[++i]);
        }
        else if(!stack.isEmpty() && chars[i] == '"'){
            StringBuilder result = new StringBuilder();
            for(Character c : stack){
                result.append(c);
            }
            String token = result.toString();

            if(key == null)
                 key = token;
            else{
                val = token;
                System.out.println( String.format("Key is %s, value is %s", key, val));
                key = null;
                val = null;
            }
            stack.clear();

        }
        else{
            // move on
        }
    }

    }



    public static void main(String [] args){

        String str = "  { \"key1\":\"val1\",  \"key2\":\"val2\",  \"key3\":\"val4\", }";
        parse(str);
    }
}
