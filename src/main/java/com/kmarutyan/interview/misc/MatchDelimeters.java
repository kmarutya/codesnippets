package com.kmarutyan.interview.misc;

import java.util.*;

public class MatchDelimeters {


    public static final char[] DELIMS =  {'(', ')', '[', ']', '{','}'};
    public static final String dStr =  new String(DELIMS);

    public static boolean isMatched(String expr){
        Stack<Character> stack = new Stack<>();
        for(char c: expr.toCharArray()){
              int i =  dStr.indexOf(c);
              if( i < 0) // move to next
                  continue;
              if( i%2 == 0) { // opening char - no previous check is needed
                  // is opening char{}
                  stack.push(c);
              }
              else{ // if closing character
                  char last = stack.pop();
                  if(i -dStr.indexOf(last)  != 1){
                      return false;
                  }
              }
        }


        return stack.isEmpty();
    }


    public static void main( String [] args){
        String expr;
         expr = "([)]";
        System.out.println(String.format("Expression %s is %s",expr, isMatched(expr)));


        expr = "()[]";
        System.out.println(String.format("Expression %s is %s",expr, isMatched(expr)));

        expr = "([])";
        System.out.println(String.format("Expression %s is %s",expr, isMatched(expr)));

        expr = "([]";
        System.out.println(String.format("Expression %s is %s",expr, isMatched(expr)));
    }
}
