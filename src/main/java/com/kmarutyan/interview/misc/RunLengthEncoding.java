package com.kmarutyan.interview.misc;

public class RunLengthEncoding {

    public static String lengthEncoding(String s){
        StringBuilder sb = new StringBuilder();

        Character lastChar = s.charAt(0);
        int curCount = 0;
        for(Character c: s.toCharArray()){
            if(c == lastChar){
                curCount++;
            }
            else{
                sb.append(curCount).append(lastChar);
                curCount = 1;
                lastChar = c;
            }


        }

        // don't forget the reminder
        sb.append(curCount).append(lastChar);

        return sb.toString();

    }

    public static void main(String... args){

        String s = "AAABBAAAAABBBCCCCCCCCCAAAAA";
        System.out.println(lengthEncoding(s));
        // 3A2B5A3B9C5A
        // 3A2B5A3B9C

    }
}


