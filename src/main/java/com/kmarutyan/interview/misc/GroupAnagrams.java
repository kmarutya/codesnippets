package com.kmarutyan.interview.misc;

import java.util.*;

public class GroupAnagrams {


    public static void group(List<String> words){
        Map<Long, List<String>> results = new HashMap<>();

        for(String word: words){
            Long score = score(word);
            if(score <= 0)
                    continue;
            List<String> anagrams = results.getOrDefault(score, new ArrayList<String>());
            anagrams.add(word);
            results.put(score,anagrams );
        }

        for(Long score: results.keySet()){
            System.out.print(String.format("Score: %d \t", score));
            results.get(score).forEach(w -> System.out.print(w + "\t"));
            System.out.println();
        }

    }

    public static long score(String word){
        long score = -1;
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        for(char c: word.toCharArray()){
            if(Character.isLetter(c)){
                score  = score + 512 * c;
            }
        }

        return score;

    }

    public static void main(String [] args){
        List<String> words = Arrays.asList(new String[]{"cat", "dog", "act", "door", "odor"});
        group(words);

        System.out.println(score("cat"));
        System.out.println(score("atc"));


    }
}

