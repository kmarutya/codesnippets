package com.kmarutyan.interview.misc;


import java.util.*;
import java.util.stream.IntStream;

public class SingleRiffleCheck {

    public static List<Integer> getStack(){
        List<Integer> stack = new ArrayList<Integer>();
        IntStream.rangeClosed(1, 52).forEach(i -> stack.add(new Integer(i)));

        return stack;
    }

    public static  List<Integer> purelyRandomShuffle( ){
        List<Integer> sorted =  getStack();
        List<Integer> shuffled =  new ArrayList<>();
        Random r = new Random();

        for(int i = 0; i< 52; i++){
            int ind = r.nextInt( sorted.size());
            int card = sorted.remove(ind);
            shuffled.add(card);
        }

        return shuffled;

    }
    public static  List<Integer> singleRiffleShuffle( ){
        List<Integer> stack =  getStack();
        Random rand = new Random();
        int split = rand.nextInt(stack.size()+1);
        List<Integer> left =  stack.subList(0, split);
        List<Integer> right = stack.subList(split,stack.size());
        return shuffle(left,right);

    }


    public static  List<Integer> shuffle(List<Integer> left, List<Integer> right){
        List<Integer> mergedList = new ArrayList<>();

        Random rand = new Random();

        int l = 0;
        int r = 0;
        while(!(l <left.size() ) && !(r < right.size())){
            System.out.println(String.format("Left %d of %d, right %d of %d", l ,left.size(), r, right.size()));
            boolean isLeft = rand.nextBoolean();
            if(isLeft){
                mergedList.add(left.get(l++));
            }
            else{
                mergedList.add(right.get(r++));
            }
        }



        mergedList.addAll(right.subList(r, right.size()));
        mergedList.addAll(left.subList(l, left.size()));

        return mergedList;
    }


    public static  boolean isSingleRuffle(List<Integer> shuffle){
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        Integer prevLeft = shuffle.remove(0);
        Integer prevRight = null;
        left.add(prevLeft);


        for(int i = 1; i < 52;i++){
            Integer next = shuffle.remove(0);
            if(next - prevLeft == 1 ){
                prevLeft = next;
                continue;
            }
            if(prevRight == null || next  - prevRight == 1){
                prevRight = next;
                continue;
            } else {
               return false;
            }

        }
        return true;
    }

    public static void main(String [] args){
       List<Integer> singleRiffle = singleRiffleShuffle( );
       List<Integer> randomShuffle = purelyRandomShuffle( );

        System.out.println(isSingleRuffle(singleRiffle));
        System.out.println(isSingleRuffle(randomShuffle));

//        System.out.println(singleRiffle.size());
//        System.out.println(randomShuffle.size());

//        singleRiffle.forEach(i -> System.out.println(i));
    }

}

enum Suite {
    HEART,
    SPADES,
    CLUBS,
    DIAMONDS
}

class Card{
    public Card(int v){
        this.val = v;
    }
    public Integer val;

    @Override
    public int hashCode() {
        return val.hashCode();
    }

    @Override
    public boolean equals(Object aThat) {
        //unusual: multiple return statements
        if (this == aThat) return true;
        if (!(aThat instanceof Card)) return false;
        Card that = (Card) aThat;
        return this.val.equals(that.val);

    }

}