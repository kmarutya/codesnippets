package com.kmarutyan.interview.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

       public static boolean wordbreak1(String word, List<String >dict){
           return wordbreak1(word, dict, 0);
       }

    public static boolean wordbreak1(String word, List<String >dict, int start){
        if(start == word.length())
            return true;

        for(String w: dict){
            int len = w.length();
            int end = start + len;

            if(end > word.length())
                continue;

            if(word.substring(start, end).equals(w)){
                if( wordbreak1(word, dict, end)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordbreakDP(String word, List<String >dict){
       boolean [] dp = new boolean[word.length()+1];
       dp[0] =  true;


       for(int i = 0; i < word.length(); i++){
            if(dp[i]== false)
                continue;

            for(String w: dict){
                int len = w.length();
                int end = i + len;
                if(end > word.length()){
                    // skip to next word
                    continue;
                }

                if(dp[end])
                    continue;

                if(word.substring(i, end).equals(w)){
                    dp[end] = true;
                }
            }

       }
      return dp[word.length()];
    }

    public static boolean wordbreak3(String word, List<String >dict){
           int [] pos = new int [word.length() + 1];
           Arrays.fill(pos, -1);
           pos[0]=0;

           for(int i = 0; i < word.length(); i++){
               if(pos[i] != -1){
                   for(int j = i + 1; j <= word.length(); j++){
                       String token = word.substring(i, j);
                       if(dict.contains(token))
                           pos[j] = 0;
                   }
               }
           }

           boolean ans = (pos[pos.length -1] == -1 ) ?  false:true;
           return ans;
    }


        public static void main(String [] args){
        String [] d = {"trainer", "my", "interview"} ;
        List<String > dict = Arrays.asList(d);
        System.out.println(wordbreak1("myinterviewtrainer", dict));
        System.out.println(wordbreakDP("myinterviewtrainer", dict));
        System.out.println(wordbreak3("myinterviewtrainer", dict));



        }
}
