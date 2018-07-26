package com.kmarutyan.interview.dp;

import java.util.*;

public class DivingBoard {
public static int shorter = 3;
public static int longer = 7;


    public static Set<Integer> getAllBoards(int k){
        if(k == 0){
            Set<Integer> base = new HashSet<>();
            base.add(0);
            return base;
        }

        Set<Integer> curboards = new TreeSet<>();
        for(Integer l : getAllBoards(k-1)){
            curboards.add(l + longer);
            curboards.add(l + shorter);
        }
        return curboards;

    }
    public static Set<Integer> getBoardsMemo(int k){
        Map<Integer, Set<Integer>> memo = new HashMap<>();
        return getAllBoardsMemo(k, memo);
    }
    public static Set<Integer> getAllBoardsMemo(int k,  Map<Integer, Set<Integer>> memo){
        if(k == 0){
            Set<Integer> base = new HashSet<>();
            base.add(0);
            return base;
        }
        if(memo.containsKey(k))
            return memo.get(k);

        Set<Integer> curboards = new HashSet<>();
        for(Integer l : getAllBoardsMemo(k-1, memo)){
            curboards.add(l + longer);
            curboards.add(l + shorter);
        }
        memo.put(k,curboards);
        return curboards;

    }
    public static void main(String [] args){
//        System.out.println(getAllBoards(4) );
        System.out.println(getBoardsMemo(5) );



    }
}
