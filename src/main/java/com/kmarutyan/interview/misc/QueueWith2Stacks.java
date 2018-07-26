package com.kmarutyan.interview.misc;

import java.util.Deque;
import java.util.Stack;

public class QueueWith2Stacks   { //implements Deque<Integer>
    Stack<Integer> spush = new Stack<>();
    Stack<Integer> spull = new Stack<>();


    public void push(int i){
        while(!spull.isEmpty()){
            spush.push(spull.pop());
        }
        spush.push(i);
    }

    public int pop(){
        while(!spush.isEmpty()){
            spull.push(spush.pop());
        }
        return spull.pop();
    }

    public int peek(){
        while(!spush.isEmpty()){
            spull.push(spush.pop());
        }
        return spull.peek();
    }

    public boolean isEmpty(){
        return spull.isEmpty() && spush.isEmpty();
    }

    public static void main(String [] args){
        QueueWith2Stacks queue = new QueueWith2Stacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);

        while(!queue.isEmpty()){
            System.out.println(queue.pop());
        }

    }
}
