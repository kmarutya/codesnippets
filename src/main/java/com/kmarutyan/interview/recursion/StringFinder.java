package com.kmarutyan.interview.recursion;

/**
 * Created by apple on 4/15/17.
 */
public class StringFinder {
    public static boolean findString(String longStr, String strToFind ){
        if(longStr == null || strToFind == null) return false;
        if(longStr.length() < strToFind.toString().length()) return false;

        if( longStr.substring(0, strToFind.length()).equals(strToFind)){
            return true;
        }
        else{
           return findString(longStr.substring(1), strToFind);
        }


    }

    public static void main(String [] args){

       System.out.println( StringFinder.findString("Mississippi", "sip"));
        System.out.println( StringFinder.findString("Mississippi", "sap"));
    }
}
