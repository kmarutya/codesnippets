package com.kmarutyan.interview.misc;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MasterMind {

    public static void play(){

        for(int i = 0;i< 4; i++){
            String game = litCorners();
            String guess = litCorners();
            System.out.println(String.format("Game = '%s', guess  = '%s', score =%d ", game, guess, getScore(game, guess)));
        }


    }
    public static int getScore(String guess, String game){
        int countHits = 0;
        for(int i = 0; i< game.length(); i++){
            if( game.substring(i, i+1).equals(guess.substring(i,i+1))){
                countHits ++;
            }
        }

        Map<Character, Integer> map  = new HashMap<>();
        for(Character c: game.toCharArray()){
            if(!map.containsKey(c) )
                map.put(c, 0);
            map.put(c, 1 + map.get(c));
        }
        int pseudoHits = 0;
        for(Character c: guess.toCharArray()){
            if(map.containsKey(c) && map.get(c) > 0){
                pseudoHits++;
                map.put(c, map.get(c)-1);
            }
        }

        int score = pseudoHits - countHits;
        System.out.println("Pseudo hits = " + pseudoHits);
        System.out.println("Direct hits = " + countHits);
        System.out.println("Total score = " + score);


        return score;
    }
    public static String litCorners(){
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for(int i = 0;i< 4; i++){
            if(rand.nextInt(4) == 1){
                sb.append("R");
            }
            else if(rand.nextInt(4) == 0){
                sb.append("G");
            }
            else if(rand.nextInt(4) == 2){
                sb.append("Y");
            }
            else{
                sb.append("B");
            }
        }

        return sb.toString();

    }
    public static void main(String... args){
        play();
    }
}
