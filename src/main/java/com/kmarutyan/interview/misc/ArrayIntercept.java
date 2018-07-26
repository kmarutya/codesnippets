package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayIntercept {
    public static List<Integer> intercept(List<Integer> l1, List<Integer> l2) {
        List<Integer>ans = new ArrayList<>();

        int i  = 0;
        int j = 0;

        while( i< l1.size() && j < l2.size()){
            int t1 = l1.get(i);
            int t2 = l2.get(j);

            if(t1 == t2){
                ans.add(t1);
                i++;
                j++;
            }
            else if (t1 < t2){
                i++;
            }
            else{
                j++;
            }

        }

        return ans;

    }




    public static void main(String [] args){
        int [] a1 = {1,5, 9, 15, 16, 22, 29, 45};
        int [] a2 = {2,5, 8, 15, 16, 23, 24, 25, 29, 49};

//        List l1 = Arrays.stream(a1).boxed().collect(Collectors.toList());
//        List l2 = Arrays.stream(a2).boxed().collect(Collectors.toList());

        List<Integer> l1 = Arrays.asList(1,5, 9, 15, 16, 22, 29, 45);
        List<Integer> l2 = Arrays.asList(2,5, 8, 15, 16, 23, 24, 25, 29, 49);


        intercept(l1, l2).stream().forEach( System.out::println);

    }
}
