package com.kmarutyan.interview.regex;

public class PatternMatching {
    public static boolean isMatchBruteForce(String text, String pattern){
        char [] t = text.toCharArray();
        char [] p = pattern.toCharArray();

        for(int i =0; i < t.length; i++){
            String main = text.substring(0, i);
            for(int s = i; s <= t.length; s++){
                for(int e = s; e <= t.length; e++){
                    String alt = text.substring(s, e);
                    String cand = buildFromPattern(pattern, main, alt);
                    if(cand.equalsIgnoreCase(cand)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isMatch(String text, String pattern){
        if(pattern.isEmpty()){
            return text.isEmpty();
        }
        char mainChar  = pattern.charAt(0);
        char altChar = (mainChar == 'a')? 'b' :'a';

        int mainCount = countOfMain(pattern, mainChar);
        int altCount = pattern.length() - mainCount;
        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = text.length()/mainCount;

        for(int mainSize = 0; mainSize <= maxMainSize; mainSize++){
            String first = text.substring(0, mainSize);
            int remainingLength = text.length() - mainCount * mainSize;
            if(altCount  == 0 || remainingLength % altCount == 0){
                int altIndex = firstAlt * mainSize;
                int altSize = (altCount == 0) ? 0 : remainingLength /altCount ;
                String second = (altCount == 0) ? "" : text.substring(altIndex, altIndex + altSize);
                String cand = buildFromPattern( pattern, first, second);
                if( cand.equalsIgnoreCase(text)){
                    System.out.println(String.format("(a,b) = (%s,%s)", first, second));
                    return true;
                }
            }
        }
        return false;
    }

    public static int countOfMain(String pattern, char c){
        int count = 0;
        for(char cp: pattern.toCharArray()){
            if(cp == c)
                count++;
        }

        return count;
    }
    public static String buildFromPattern(String pattern, String main, String alt){
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);
        for(char c: pattern.toCharArray()){
            if(c == first){
                sb.append(main);
            }
            {
                sb.append(alt);
            }
        }

        return sb.toString();
    }
    public static void main(String...args){
        String text = "catcatgocatgo";
        String pattern  = "ab";
//        System.out.println(isMatchBruteForce(text, pattern));
//        System.out.println(isMatch(text, pattern));
//        System.out.println(isMatch("caca", pattern));
//
//        System.out.println(isMatch("cacacd", "ab"));
        System.out.println(isMatch("cacacd", "abb"));
        System.out.println(isMatch("cacacd", "bbb"));
        System.out.println(isMatch("cacacd", "abba"));







    }
}
