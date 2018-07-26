package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ParenthesisPermutations {
    public static <PrintableToString> void print(PrintableToString... args) {
        for(PrintableToString pts: args)
            System.out.print(pts);
        System.out.println();
    }

    public static List<String> getPermutations(int n){
        print(n);
        if(n <=0){
            return new ArrayList<String>();
        }
        else if(n == 1){
            return  Arrays.asList("()");
        }

        List<String> p1 = getPermutations(n-1);

        List<String> out = new ArrayList<>();
        for(String p: p1) {
            int l = 0;
            int sum = 0;
            String nperm = null;

            while (l <= p.length()) {
                if (sum == 0) {
                    nperm = p.substring(0, l) + "(" + p.substring(l);
                    sum++;
                }
                if (sum == 1) {
                    nperm = nperm.substring(0, l + 1) + ")" + nperm.substring(l + 1);
                    out.add(nperm);
                    sum--;
                }
                l++;

            }
        }
        return out;

    }


    public static void main(String [] args){
        int n  = 3;

        // get permutations
        Collection<String> perms =  getPermutations(n);

        //print
        perms.stream().forEach(p -> System.out.println(p));

    }
}
