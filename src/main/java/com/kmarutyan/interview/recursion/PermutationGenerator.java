package com.kmarutyan.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 4/15/17.
 */
public class PermutationGenerator {

    public static List<String> generatePermutations(String word){
        List<String> words = new ArrayList<String>();
        if(word.length() == 0){
            words.add(word);
            return words;
        }
        for(int i = 0; i < word.length(); i++){
            String shortWord = word.substring(0,i) + word.substring(i+1);
            List<String> shortWords = generatePermutations(shortWord);

            for(String sw: shortWords){
                words.add(word.charAt(i) + sw);
            }

        }

        return words;
    }


    public static void generatePermutationsAndPrint(String word){
        List<String> words =  generatePermutations(word);
        System.out.println(String.format("Length of permutated list for word %s is %d", word, words.size()));
        for(String w : words){
            System.out.println(w);
        }


    }



    public static void main(String [] args){
        PermutationGenerator.generatePermutationsAndPrint("moza");
        PermutationGenerator.generatePermutationsAndPrint("beat");


    }
}





