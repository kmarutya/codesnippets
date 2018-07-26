package com.kmarutyan.interview.misc;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BracketValidator {
    public static List<Character> openers = Arrays.asList('{','[', '(');
    public static List<Character> closers = Arrays.asList('}',']', ')');


    public static boolean isValid(String str){
        Stack<Character> stack = new Stack();

        for(Character c: str.toCharArray()){
            if(openers.contains(c)){
                stack.push(c);
            }
            if (closers.contains(c)){
                if(stack.isEmpty())
                    return false;
                if( stack.pop() != openers.get( closers.indexOf(c)))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static int findMatchingParenthesis(String str, int startIndex){
        Stack<Character> stack  = new Stack();

        char [] chars =  str.toCharArray();
        for(int i = startIndex; i < chars.length; i++){
            char c = chars[i];
//            System.out.println(String.format("i = %d %c stack-size = %d" , i, c, stack.size()));

            if (c == '('){
                stack.push(c);
            }
            if(c == ')'){
                stack.pop();
                if(stack.isEmpty())
                    return i;
            }
        }

        return -1;
    }
    public static void main(String [] args){
        System.out.println( isValid("{ [ ] ( ) }"));
        System.out.println( isValid("{ [ ( ] ) }"));
        System.out.println( isValid("{ [ }"));

        System.out.println(findMatchingParenthesis("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.", 10));

    }
}
