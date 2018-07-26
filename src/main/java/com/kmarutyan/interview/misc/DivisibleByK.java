package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class DivisibleByK {

    public static boolean checkPairs(int [] nums, int k){
        int modulusCounts[] = new int[k];

        for (int num: nums)
            modulusCounts[num %k]++;

        System.out.println("modulus: "+ Arrays.toString(modulusCounts));
        // As these will not form pair with anyone else
        if(modulusCounts[0] % 2 != 0)
            return false;
        // These will also not form pair with anyone else
        if (k % 2 == 0) {
            if (modulusCounts[k/2] %2 != 0)
                return false;
        }

        for (int i = 1; i <= k/2; i++)
            if (modulusCounts[i] != modulusCounts[k-i])
                return false;


        return true;
    }

    public static void main(String [] args){
        int [] ints = new int []{12, 30, 20, 22};
        System.out.print(checkPairs(ints, 6));

    }
}
