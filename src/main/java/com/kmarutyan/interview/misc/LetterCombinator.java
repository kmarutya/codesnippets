package com.kmarutyan.interview.misc;

import java.sql.SQLOutput;
import java.util.*;

public class LetterCombinator {
    public static List<String[]> list  = new ArrayList<>();
    static{
        list.add(new String []{""});
        list.add(new String []{"a","b", "c"});
        list.add(new String []{"d","e", "f"});
        list.add(new String []{"g","h", "i"});
        list.add(new String []{"j","k", "l"});
        list.add(new String []{"m","n", "o"});
        list.add(new String []{"p","q", "r", "s"});
        list.add(new String []{"t","u", "v"});
        list.add(new String []{"w","x", "y", "z"});
    }


    public static List<String> getCombinations(int [] items){
        List<String> words = new ArrayList<>();

        Queue<String> q = new LinkedList();
        q.add("");

        while(!q.isEmpty()){

            String head = q.remove();
            if(head.length()== items.length){
                words.add(head);
            }
            else{
                String [] nextChars = list.get(items[head.length()]);
                for (String s: nextChars){
                    q.add(head + s);
                }
            }
        }


        return words;

    }
    public static void main(String... args){

        getCombinations(new int []{2,3,1}).forEach(l -> System.out.println(l));
    }
}
