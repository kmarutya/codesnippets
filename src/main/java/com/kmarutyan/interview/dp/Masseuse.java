package com.kmarutyan.interview.dp;

import java.util.Arrays;
import java.util.List;

public class Masseuse {

    public static int maxMinutesIter(int [] mins){
        int oneAway = 0;
        int twoAway = 0;
        int max = 0;
        for(int i  = mins.length -1; i>=0; i--){
            int max1 = mins[i] + twoAway;
            int max2 =  oneAway;
            max = Math.max(max1, max2);
            twoAway = oneAway;
            oneAway = max;
        }

        return max;
    }
    public static int maxMinutes(int [] mins){
        int [] memo = new int[mins.length];
        Arrays.fill(memo, -1);
        return best(mins, 0, memo);
    }

    public static int best(int [] mins, int index, int [] memo){
        if(index >= mins.length )
            return 0;
        if(memo[index]>=0){
            return memo[index];
        }
        int r1 = best(mins, index +2, memo ) + mins[index];
        int r2 = best(mins, index+1, memo) ;

        int max = Math.max(r1, r2);
        memo[index ] = max;
        return  max;
    }
    public static void main(String[] args) {
        int [] input = {30, 15, 60,75,45, 15, 45};
        System.out.println(maxMinutes(input));
        System.out.println(maxMinutesIter(input));

    }
}
