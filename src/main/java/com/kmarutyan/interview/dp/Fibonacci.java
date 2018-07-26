package com.kmarutyan.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Created by apple on 7/25/18.
 */
public class Fibonacci {

    public static int fib(int n) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);

        for (int i = 2; i <= n; i++) {
            int val = fibs.get(i - 1) + fibs.get(i - 2);
            fibs.add(val);
        }
        return fibs.get(n);
    }

    public static int fib3(int n) {
        // debugging
//        if(n==3) System.out.println("Fib 3 value 3");
        // Safety net
        if (n <=0)
            return 0;
        if (n <=2)
            return 1;
        else
            return fib3(n - 1) + fib3(n - 2);
    }

    public static int fibTail(int n) {
        return fib(n, 0, 1);
    }


    public static int fib(int n, int i1, int i2) {
        if (n == 0)
            return i1;
        if (n == 1)
            return i2;

        return fib(n - 1, i2, i2 + i1);
    }

    public static void main(String[] args) {
//        int i = 2;
//        System.out.println(String.format("fibTail(%1$d) = %2$d",i,fibTail(i)));

//        Function<Integer, Integer> cust_fib = (i)-> Fibonacci.fib3(i);
//
        IntStream.rangeClosed(0, 10).forEach(i ->
                System.out.println(String.format("Fibonacci (%1$d) = %2$d", i, fib3(i)))
        );

    }
}

