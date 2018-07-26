package com.kmarutyan.interview.regex;

import java.util.Arrays;

public class WildCardMatching {

    public static boolean isMatch(String text, String pattern){

        return isMatch2(text, pattern, text.length(), pattern.length());
    }
    public static boolean isMatch2(String text, String pattern, int n, int m){
        if(m == 0){
            return (n == 0);
        }
        boolean [][] lookup = new boolean[n+1][m+1];
        char [] p = pattern.toCharArray();
        char [] t = text.toCharArray();

        // let's feel up the first row  - empty text
        // "" or "*" or "**" or "***" should all match
        lookup[0][0] = true;
        for(int j = 1; j<=m ; j++){
            if( p[j - 1] == '*' )
                lookup[0][j]  = lookup[0][j-1];
        }

        // now let's move to core of the problem
        // and check text[i] at each iteration
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(p[j - 1] == '*'){
                    lookup[i][j] = lookup[i][j-1] || lookup[i-1][j];
                }
                else if (p[j -1] == '?'){
                    lookup[i][j] = lookup[i - 1][j - 1];
                }
                else if( p[j-1] == t[i-1]){
                    lookup[i][j] = lookup[i - 1][j - 1];
                }
                else{
                     lookup[i][j] = false;
                }
            }
        }

        return lookup[n][m];
    }



        public static boolean isMatch(String text, String pattern, int n, int m){
        // empty pattern only can match empty string
        if(m ==0 )
            return (n == 0);

        boolean [][] lookup = new boolean [n+1][m+1];
        for(int i  = 0; i < n+1 ; i++){
            Arrays.fill(lookup[i], false);
        }

        // empty pattern can match with empty string
        lookup[0][0] = true;


        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];
        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                                        lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        text.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }
        return lookup[n][m];
    }

    public static boolean isMatch2(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex+1;
                iIndex++;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }

        return j == p.length();
    }

    public static void main(String...args){
        String text = "baaabab";
        String pattern =  "ba*a?";
        System.out.println(isMatch(text, pattern));
        System.out.println(isMatch("baba", pattern));
        System.out.println(isMatch("babav", pattern));

//        System.out.println(isMatch2(text, pattern));
    }
}
