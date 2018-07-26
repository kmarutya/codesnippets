package com.kmarutyan.interview.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    public static int minimumRooms(Tuple [] schedules){
        int maxRooms = 0;
        for(int hour = 0; hour <=24; hour++){
            int curSlots = 0;
            for(Tuple sched: schedules){
                if(hour >= sched._1 && hour <= sched._2){
                    curSlots++;
                }
            }
            maxRooms = Math.max(maxRooms, curSlots);
        }

        return maxRooms;
    }

    public static boolean isOverlap(Tuple [] schedules){
        return minimumRooms(schedules ) > 1? true:  false;
    }

    public static int minimumRooms2(Tuple [] schedules){
        int maxRooms = 0;
        Comparator<Tuple> byStartTime = (Tuple s1, Tuple s2) -> {
            int diffStart = s1._1 - s2._1;
            int diffStop = s1._2 - s2._2;
            return (diffStart == 0)? diffStop:diffStart;

        };

        List<Tuple> scheds = Arrays.asList(schedules);
        Collections.sort(scheds, byStartTime);


        for(int i = 0; i < scheds.size(); i++){
            int curRooms = 1;
            Tuple cur = scheds.get(i);


            for(int nextSched = i+1; nextSched < scheds.size(); nextSched++){
                Tuple next = scheds.get(nextSched);

                if( cur._2 > next._1 && cur._2 < next._2 ){
                    curRooms++;
                    maxRooms = Math.max(maxRooms, curRooms);
                }
                else{
                    // break loop
                    break;
                }
            }

        }


        return maxRooms;
    }

   // Collections.sort(footballTeam, playerComparator);

    public static void main(String [] args){
        Tuple [] schedules ={
                new Tuple(1,4),
                new Tuple(5,6),
                new Tuple(8,9),
                new Tuple(3,6),
                new Tuple(9,18),
                new Tuple(13,16),
                new Tuple(14,15),
                new Tuple(1,15),
        };

        System.out.println(String.format("Maximum room needed = %s",minimumRooms2(schedules )));

    }
}

class Tuple{
    public Tuple ( int a, int b){
        _1 = a;
        _2 = b;

    }
    public int _1, _2;

  }