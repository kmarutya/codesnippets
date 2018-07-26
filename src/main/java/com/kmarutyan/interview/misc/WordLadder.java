package com.kmarutyan.interview.misc;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {

    public static String wordLadder(String start, String end, String [] dict){
        if(start == null || end == null || start.length() != end.length())
            return "";

        Set<String> ds =  Arrays.stream(dict).filter(l -> l.length() == start.length()).collect(Collectors.toSet());

        return wordLadder(start, end, "", ds );
    }
    public static String wordLadder(String start, String end, String res, Set<String> ds){

        for(int i = 0; i < start.length(); i++){
            for(char c='a'; c<='z'; c++){
                char [] schars = start.toCharArray();
                char [] cand = Arrays.copyOf(schars, schars.length);
                cand[i] = c;
                String str = new String(cand);

                if(str.equalsIgnoreCase(end)){
                    res = String.format("%s -> %s", res, str);
                    return res;
                }

                if(ds.contains( str)){
                    res = String.format("%s -> %s", res, str);
                 //   System.out.println(res);

                    ds = ds.stream().filter(l -> !l.equalsIgnoreCase(str)).collect(Collectors.toSet());
                    return wordLadder(str, end, res, ds);
                }
            }

        }

        return "";
    }

    public static int ladderLength(String start, String end, Set<String> dict){
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 0));
        dict.add(end);

        while(!queue.isEmpty()){
            WordNode top = queue.poll();
            String word = top.word;

            if(word.equalsIgnoreCase(end))
                return top.numSteps;

            char[] chArr = word.toCharArray();
            for(int i = 0; i < chArr.length; i++){
                for(char c = 'a'; c <= 'z'; c++) {
                    char [] arr = Arrays.copyOf(chArr, chArr.length);
                    arr[i] = c;

                    String cand = new String(arr);
                    if(dict.contains(cand)){
                        queue.add(new WordNode(cand, top.numSteps + 1));
                        dict.remove(cand);
                    }

                }
            }


        }

         return 0;
    }

    public static void main(String  [] args){
        String  [] dict = {"hot","dot","dog","lot","log"};
        String start =  "hit";
        String  end = "cog";

        System.out.println(wordLadder(start, end, dict));

        Set<String> d = Arrays.stream(dict).collect(Collectors.toSet());
        System.out.println(ladderLength(start, end, d));

    }
}


class WordNode{
    String word;
    Integer numSteps;
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}