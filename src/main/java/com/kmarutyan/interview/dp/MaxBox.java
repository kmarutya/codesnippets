package com.kmarutyan.interview.dp;

import java.util.*;
import java.util.stream.Collectors;

public class MaxBox {
    public static void print(int[][] ints){
        for (int i = 0; i < ints.length; i++){
            System.out.println(Arrays.deepToString(Arrays.stream(ints[i]).boxed().toArray()));
        }
        System.out.println();

    }

    public static Comparator<Box> boxComparator = (b1, b2) -> b1.base() - b2.base();

    public static int stackBoxes(List<Box> boxes){
        int [] memo = new int [boxes.size()];
        Arrays.fill(memo, 0);
        Collections.sort(boxes, boxComparator.reversed());
        boxes.forEach(b->System.out.println(b));
        return stackBoxes(boxes, 0, memo);
    }

    public static int stackBoxes(List<Box> boxes, int ind, int memo[]){
        if (ind >= boxes.size())
            return 0;
        if(memo[ind] > 0)
            return memo[ind];

        for(int i = ind ; i < boxes.size() ; i++){
            int maxHeight = 0;
            Box bottom = boxes.get(ind);
            for(int j = ind + 1; j < boxes.size(); j++) {
                if (boxes.get(j).base() < bottom.base()) {
                    int height = stackBoxes(boxes, j, memo);
                    maxHeight = Math.max(height, maxHeight);
                }
            }
            maxHeight = maxHeight + bottom.height;
            memo[ind] = maxHeight;
        }

        int maxHeight = Arrays.stream(memo).boxed().mapToInt(i -> i).max().getAsInt();
        return maxHeight;
    }


    public static void main(String [] args){

        int [][] sizes = {
                {4, 7, 9},
                {5, 8, 9},
                {11, 20, 40},
                {1, 2, 3}
        };

        List<Box> boxes=  new ArrayList<>();
        for (int [] b: sizes){
            boxes.add(new Box( b[0], b[1], b[2]));
            boxes.add(new Box( b[1], b[2], b[0]));
            boxes.add(new Box( b[2], b[0], b[1]));
        }
//        boxes.forEach(b->System.out.println(b));
        int totalHeight = boxes.stream().mapToInt(b-> b.height).sum();
        System.out.println("totalHeight "+ totalHeight);



        System.out.println(stackBoxes(boxes));
    }
}
class Box implements Comparable{
    int height;
    int width;
    int depth;
    public Box(int h, int w, int d){
        this.height = h;
        this.width = Math.min(w,d) ;
        this.depth =  Math.max(w,d) ;
    }

    public int base(){
        return width*depth;
    }

    public String toString(){
        return String.format("Box dimensions: (%d, %d, %d)", this.height, this.width, this.depth);
    }

    @Override
    public int compareTo(Object o) {
        if(o == null|| !( o instanceof Box))
            return 1;
        else{
            Box that = (Box)o;
            return this.base() - that.base();
        }

    }
}