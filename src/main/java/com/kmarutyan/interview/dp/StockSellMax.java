package com.kmarutyan.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockSellMax {
    Integer [] memoization ;

    public StockSellMax(int [] data){
        memoization = new Integer[data.length];
        Arrays.fill(memoization, -1);
        memoization[0] = 0;
        memoization[1] = Math.max(0, data[1]- data[0]);
    }

    public static int maxProfit(int [] prices){
        return maxProfit(prices, 0,prices.length -1);
    }

    public static int maxProfit(int [] prices, int start, int end){
        int profit = 0;
        if (end <= start)
            return 0;

        for(int i = start; i < end; i++){
            for(int j =  i+1; j <= end; j++){
                int delta = prices[j] - prices[i];
                if( delta > 0){
                    int curProfit = delta + maxProfit(prices, start, i-1 ) + maxProfit(prices, j+1, end);
                    profit = Math.max(profit, curProfit);
                }
            }
        }

        return profit;
    }

    public  int stockBuySell(int [] prices){
        if(prices ==  null || prices.length <2 ){
            return 0;
        }

        List<StockInterval> days = new ArrayList<>();
        int profit = 0;
        int count = 0;
        int i = 0;

        while(i < prices.length -1){

            // find local minima
            while(i < prices.length-1 && (prices[i+1] < prices[i])){
                    i++;
            }
            StockInterval interval = new StockInterval();
            interval.buy = i;
            days.add(interval) ;

            if( i== prices.length - 1){
                break;
            }


            // find maxima
            while(i < prices.length -1 && prices[i+1] >prices[i] ){
                    i++;
             }
             days.get(count).sell = i;
             count ++;
        }



        for(int k = 0; k < count; k++){
            StockInterval ivl = days.get(k);
            int buy = prices[ivl.buy];
            int sell = prices[ivl.sell];
            int curProfit = sell - buy;
            profit+= curProfit;

            System.out.println(String.format("" +
                    "Count = %d, buy = %d, sell =  %d  Current Profit = %d, Total Profit = %d", k, buy, sell,curProfit, profit));

        }

        return profit;


    }
    public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;
//        System.out.println(new StockSellMax(price).maxProfit(price, price.length -1));
        System.out.println(new StockSellMax(price).stockBuySell(price));
        System.out.println(maxProfit(price));

    }

}


class StockInterval {
        Integer buy = null;
        Integer sell = null;
 };