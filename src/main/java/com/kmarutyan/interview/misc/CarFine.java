package com.kmarutyan.interview.misc;

public class CarFine {
    public static int getFine(int [] cars, int date){
        int fine = 0;

        for(int car: cars){
            if (date%2 != car%2){
                fine+=250;
            }
        }


        return fine;
    }

    public static void main(String [] args){
        System.out.println(getFine(new int[] {3, 4, 1, 2}, 15));
        System.out.println(getFine(new int[] {1,2,3 }, 16));


    }
}


