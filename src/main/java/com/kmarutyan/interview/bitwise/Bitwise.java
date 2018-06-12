package com.kmarutyan.interview.bitwise;

/**
 * Created by apple on 4/19/17.
 */
public class Bitwise {
    public static void main(String [] args){
        int a = 60;
        int b = 13;
        int c = 0;


        c = a & b;        /* 12 = 0000 1100 */
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("a & b = " + c );


        c = a | b;
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("a | b = " + c );

        c = a ^ b;        /* 49 = 0011 0001 */
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("a ^ b = " + c );

        c = ~a;           /*-61 = 1100 0011 */
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("~a = " + c );

        c = a << 2;       /* 240 = 1111 0000 */
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("a << 2 = " + c );

        c = a >> 2;       /* 15 = 1111 */
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;      /* 15 = 0000 1111 */
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println("a >>> 2 = " + c );


        int number = 8; //0000 1000
        int shift = number<<1;
        System.out.println();
        System.out.println(Integer.toBinaryString(number));
        System.out.println("number<<1 : " + shift+ " " + Integer.toBinaryString(shift));

        shift = number>>1;
        System.out.println();
        System.out.println(Integer.toBinaryString(number));
        System.out.println("number>>1 : " + shift+ " " + Integer.toBinaryString(shift));

        shift = number>>>1;
        System.out.println();
        System.out.println(Integer.toBinaryString(number));
        System.out.println("number>>>1 : " + shift+ " " + Integer.toBinaryString(shift));

        number = -8; //0000 1000
        shift = number<<1;
        System.out.println();
        System.out.println("Number " + number);
        System.out.println(Integer.toBinaryString(number));
        System.out.println("number<<1 : " + shift+ " " + Integer.toBinaryString(shift));

        shift = number>>1;
        System.out.println();
        System.out.println("Number " + number);
        System.out.println(Integer.toBinaryString(number));
        System.out.println("number>>1 : " + shift+ " " + Integer.toBinaryString(shift));

        shift = number>>>1;
        System.out.println();
        System.out.println("Number " + number);
        System.out.println(Integer.toBinaryString(number));
        System.out.println("number>>>1 : " + shift+ " " + Integer.toBinaryString(shift));
        System.out.println(Integer.toBinaryString(2147483644));

    }
}
