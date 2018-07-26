package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

    public static void getSchedules(int[][] rq){
        if(rq == null){
            return ;
        }
        int n  = rq.length;

         List<Integer> sched = new LinkedList<>();
        for(int[] pair: rq){
            int course = pair[0];
            int prereq = pair[1];
            boolean inserted = false;

            for(int i = 0; i < sched.size(); i++) {
                if (sched.get(i) == prereq) {
                    if(!sched.contains(course))
                        sched.add(course);
                    inserted = true;
                    break;
                }
            }
            if(!inserted){
                sched.add(prereq);
                sched.add(course);
            }

        }

        System.out.println();
        sched.stream().forEach(System.out::print);


    }

    public static void main(String [] args){

        getSchedules( new int [][] { {1,0},{2,0},{3,1},{3,2}});
        getSchedules( new int [][] { {1,0}});
        getSchedules( new int [][] { {0,1}});



    }
}
