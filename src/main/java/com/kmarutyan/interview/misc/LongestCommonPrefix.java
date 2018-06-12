package com.kmarutyan.interview.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 6/7/18.
 */
public class LongestCommonPrefix {

    public static String longestPrefix(String [] strs){
        if (strs == null || strs.length == 0){
            return "";
        }


        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            String curStr = strs[i];
            if (curStr == null || curStr.length() == 0){
                return "";
            }


            prefix = prefix.substring(0, Math.min(prefix.length(), curStr.length()));

            while(!(curStr.substring(0, prefix.length()).equalsIgnoreCase(prefix))) {
               if(prefix.isEmpty()){
                   return prefix;
               }
               prefix = prefix.substring(0,prefix.length() - 1 );
           }
        }


        return prefix;

    }


    public static String longestPrefix2(String [] strs){
        if (strs == null || strs.length == 0){
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for(String curStr: strs) {
            if (curStr == null || curStr.length() == 0) {
                return "";
            }
            minLength = Math.min(minLength, curStr.length());
        }

        Set<String> holder = new HashSet<>();
        while(minLength > 0){
            for(String curStr: strs){
                holder.add(curStr.substring(0, minLength));
            }

            if(holder.size() > 1){
                minLength-=1;
                holder.clear();
            }
            else{
               return holder.toArray()[0].toString();
            }

        }



        return "";

    }



    public static void main(String args[]){
        String [] strings = new String[]{ "abra", "abrpdls", "abumraddkskks", "abrozec"}  ;
        System.out.println("Longest prefix: " + longestPrefix(strings));

        String [] strings1 = new String[]{ "abra", "abrpdls", "abumraddkskks", null,"abrozec"}  ;
        System.out.println("Longest prefix: " + longestPrefix(strings1));

        String [] strings2 = new String[]{ "abra", "abrpdls", "abumraddkskks", "","abrozec"}  ;
        System.out.println("Longest prefix: " + longestPrefix(strings2));

        String [] strings3 = new String[]{ "abra", "abrpdls", "abrumraddkskks", "abrozec"}  ;
        System.out.println("Longest prefix: " + longestPrefix(strings3));

        System.out.println("Longest prefix: " + longestPrefix2(strings));
        System.out.println("Longest prefix: " + longestPrefix2(strings1));
        System.out.println("Longest prefix: " + longestPrefix2(strings2));
        System.out.println("Longest prefix: " + longestPrefix2(strings3));
    }
}
