package com.kmarutyan.interview.data_structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer>s1){
        Stack<Integer>s2 = new Stack<>();
        while(!s1.isEmpty()){
            int hold = s1.pop();
            while(!s2.isEmpty() && s2.peek() > hold){
                s1.push(s2.pop());
            }
            s2.push(hold);
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return s1;
    }
    public static void main(String... args){
        Stack<Integer> stack = new Stack<>();
        Random random = new Random();
        IntStream.range(0, 20).forEach(i ->stack.push(random.nextInt(100)));
        System.out.println(stack);
        System.out.println(sortStack(stack));

//        Queue<Integer> queue = new LinkedList<>();

    }
}
