package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayLeader {

    public static int[] findLeader( int [] data){
        List<Integer> leaders = new ArrayList<>();

        int trailingMax  = Integer.MIN_VALUE;
        for(int i = data.length - 1; i>= 0; i--){
            int cur = data[i];
            if(cur > trailingMax){
                leaders.add(cur);
                trailingMax = cur;

            }

        }

        Collections.reverse(leaders);

        return leaders.stream().mapToInt(i->i).toArray();
    }

    public static void main(String... args){
         int [] data = {16,17, 4, 3, 5, 2};

         Arrays.stream(findLeader(data)).forEach(i -> System.out.print(i));

    }
}
