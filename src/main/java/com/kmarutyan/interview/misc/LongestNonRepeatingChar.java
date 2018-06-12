package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by apple on 6/6/18.
 */
public class LongestNonRepeatingChar {
     public static String findLongestSeq(String in){
         String lseq = "";
         if (in == null || in.length() == 0) {
             return lseq;
         }

         Set<Character> storage = new LinkedHashSet<>();
         for(int i = 0; i < in.length(); i++){
             char c = in.charAt(i);
             if( !storage.contains(c)){
                 storage.add(c);
             }
             else{
                 storage.remove(c);
                 storage.add(c);
             }

             System.out.println("Storage size: "+ storage.size());
             System.out.println("Seq Length: "+ lseq.length());
             if (storage.size() > lseq.length()){
                 lseq = arrToString (storage);
             }

             System.out.println(lseq);
             System.out.println();
         }
         return lseq;
     }

    public static String arrToString(Collection<Character> carray){
        String s = "";
        for( Character c :carray){
            s+=c;
        }return s;

    }
    public static void main (String [] args){
        System.out.println("Hello!");
        System.out.println(findLongestSeq("mynameiskarenandyours"));
    }
}
