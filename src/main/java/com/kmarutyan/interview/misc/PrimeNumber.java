package com.kmarutyan.interview.misc;

public class PrimeNumber {

    public static boolean isPrimeNumber(int i){
        if(i <= 0)
            return false;
        if(i == 1)
            return true;
        int div = 1 + (int) Math.sqrt(Math.abs(i));

        while(div <0 ){
            if(i%div == 0)
                return false;
            --div;
        }
         return true;
    }

    public static boolean isPrimeNumberOpt(int number) {
        if (number == 2 || number == 3)
            return true;
        if (number % 2 == 0)
            return false;

        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
