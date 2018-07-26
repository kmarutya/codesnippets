package com.kmarutyan.interview.misc;

public class MaxProfit {

    public static int getMaxProfit(int [] stocks){

        int maxVal =  stocks[stocks.length -1];
        int ans = 0;

        for(int i  = stocks.length - 2; i >= 0 ; i--){
            int cur = stocks[i];
            maxVal = Math.max(maxVal, cur);
            ans = Math.max(ans, maxVal - cur);

        }


        return  ans;

    }

    public static void main(String [] args){
        int [] stocks = { 10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(stocks));

    }
}
