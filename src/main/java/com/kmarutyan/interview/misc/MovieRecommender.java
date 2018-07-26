package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRecommender {
   public static List<Movie> movieIndex  = Arrays.asList(
       new Movie("1", 45),
        new Movie("2", 90),
            new Movie("3", 43),
            new Movie("4", 54),
            new Movie("5", 67),
            new Movie("6", 65),
            new Movie("7", 80),
            new Movie("7", 84),
            new Movie("9", 59),
            new Movie("10", 120),
            new Movie("11", 100),
            new Movie("12", 102),
            new Movie("13", 108),
            new Movie("14", 109),
            new Movie("15", 110),
            new Movie("16", 111),
            new Movie("17", 92),
            new Movie("18", 94),
            new Movie("19", 95),
            new Movie("20", 98),
            new Movie("21", 99)
    );

   public static List<Movie> recommendMovies(int flightime){
       List<Movie> movies = new ArrayList<>();
       int bestScore = Integer.MAX_VALUE;

       for(int i = 0; i < movieIndex.size(); i++) {
           Movie m1 = movieIndex.get(i);
           if (m1.duration > flightime){
               continue; // move on another movie
           }
           for (int j = i + 1; j < movieIndex.size(); j++) {
               Movie m2 = movieIndex.get(j);
               if (m2.duration > flightime)
                   continue; // move on another movie
               int curScore = flightime - m2.duration - m1.duration;
//               System.out.println(String.format("Movies  %s %s = %d", m1, m2, m2.duration + m1.duration));
//               System.out.println(String.format("Current score = %d", curScore));
               if (curScore > 0 && curScore < bestScore) {
                   movies.clear();
                   movies.add(m1);
                   movies.add(m2);
                   bestScore = curScore;
               }

           }
       }
       System.out.println(String.format("Best Score: %d ", bestScore));
       return movies;
   }

    public static void main(String... args){
        recommendMovies(235).forEach(m -> System.out.println(m));
        recommendMovies(200).forEach(m -> System.out.println(m));


    }

}

class Movie{
    int duration;
    String name;

    Movie(String aName, Integer aDuration){
        this.duration = aDuration;
        this.name = aName;
    }

    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Object that){
        if(this == that)
            return true;
        Movie thatMovie = (Movie) that;

       return this.name.equals(thatMovie.name);
    }
    public String toString(){
        return String.format("%s-%d", name, duration);
    }
}
