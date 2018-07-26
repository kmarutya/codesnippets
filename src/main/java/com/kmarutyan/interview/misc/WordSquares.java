package com.kmarutyan.interview.misc;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquares {
    public static boolean isWordSquare(String [] words){
        // sanity checks
        if(words == null || words.length == 0 ){
            return false;
        }

        int sqSide =  words.length;
        // make sure all words are of the same length
        for(int i = 0; i < words.length; i++){
           if( sqSide != words[i].length()){
               return false;
           }
        }

        for(int v = 0; v < sqSide; v++ ){
            for(int h = 0; h < sqSide; h++){
                char vh = words[v].charAt(h);
                char hv = words[h].charAt(v);

                if( vh != hv){
                  //  System.out.println(String.format("V = %d,H = %d, vh = %s, hv = %s ", v, h, vh, hv));
                    return false;
                }

            }
        }

        return true;
    }

    public static List<List<String>> findWordSquares(String [] words){
        List<List<String>> perms = permutations(Arrays.asList(words));

        for(List<String> l: perms){
            l.forEach(w->System.out.print(w+"\t"));
            System.out.println();
        }
        List<List<String>> res =  new ArrayList<>();

        int side =  words[0].length();

        for(List<String> list: perms ){
            List<String> cand =  new ArrayList<>();

            for(int i = 0; i < side; i++){
                cand.add(list.get(i));
            }

            String [] arr =  cand.toArray(new String[cand.size()]);
            if( isWordSquare ( arr) ){
                res.add(cand);

            }
        }

        return res;

    }

    public static List<List<String>> permutations(List<String>  words){
        List<List<String>> perms = new ArrayList<>();

        if(words.size() == 1) {
            perms.add(words);
            return perms;
        }

        for(int i = 0; i< words.size(); i++ ){
            List<String> others = new ArrayList<>();
            others.addAll(words);
            others.remove(i);

            for(List<String> curPerm: permutations(others) ){
                curPerm.add(words.get(i));
                perms.add(curPerm);
            }
        }

        return perms;

    }

    public static void main(String [] args){

        String [] words = {"AREA", "BALL", "DEAR", "LADY", "LEAD", "YARD"};
        String [] words1 = {"BALL", "AREA", "LEAD", "LADY"};
        String [] words2 = {"LADY", "AREA", "DEAR", "YARD"};
        String [] words3 = {"LADY", "AREA", "DEAR", "LEAD"};

/*
    LADY
    AREA
    DEAR
    LEAD
 */
//        System.out.println(isWordSquare(words1));
//        System.out.println(isWordSquare(words2));
//        System.out.println(isWordSquare(words3));

        for(List w: findWordSquares(words)){
            System.out.println("New Square Array Starts Here");
            w.stream().forEach(System.out::println);
        }

    }
}
