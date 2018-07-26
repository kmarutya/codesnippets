package com.kmarutyan.interview.misc;

public class InflictionPointRotatedArray {

    public static int findInflictionWord(String [] words){
        if(words == null || words.length == 0){
            return -1;
        }

        int l = 0;
        int r = words.length-1;
        int mid = (l + r)/2;




        while(l < r){
            if( words[mid].compareTo(words[l]) > 0){
                // move on
                l = mid +1;
            }
            else if( words[mid].compareTo(words[l]) < 0){
                // move on
                r = mid;
            }
            else  if( words[r].compareTo(words[mid]) > 0) {
                r = mid-1;
            }
            else  if( words[r].compareTo(words[mid]) < 0) {
                l = mid;
            }
            mid = (l+r)/2;

        }


        return mid;
    }


    public static void main(String [] args){
        String  []   words = {
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage"
        };

        int i = findInflictionWord(words);
        System.out.println(String.format("int i = %d , infliction word = %s", i, words[i]));


    }
}
