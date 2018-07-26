package com.kmarutyan.interview.misc;

public class ShortestSubsequence {
    public static Range findShortestSuperseqenceBruteForce(int [] data, int [] seq){
        Range minRange = new Range(-1, Integer.MIN_VALUE);
        for(int i = seq.length; i < data.length ; i++){
            int max = findClosure(data, seq, i);
            Range curRange = new Range(i, max);
            if(curRange.shorterThen(minRange)){
                minRange = curRange;
            }
        }

        return minRange;
    }

    public static Range findShortestSuperseqence(int [] data, int [] seq){
        Range minRange = new Range(-1, Integer.MIN_VALUE);
        for(int i = seq.length; i < data.length ; i++){
            int max = findClosure(data, seq, i);
            Range curRange = new Range(i, max);
            if(curRange.shorterThen(minRange)){
                minRange = curRange;
            }
        }

        return minRange;
    }

    public static int findClosure(int [] data, int [] seq, int index){
        int max = -1;
        for(int elem: seq){
            int pos = findNextInstance(data, elem, index);
            if(pos < 0)
                return -1;
            max = Math.max(max, pos);
        }
        return max;

    }
    public static int findNextInstance(int [] data, int elem, int index){
        int anws = -1;
        for(int i=index; i < data.length; i++){
            if(data[i] == elem )
                return i;
        }
        return anws;
    }

//
//    public static int [][] getNextElementMulti(int [] big, int [] small){
//        int [][] out = new int [small.length][big.length];
//        for(int i = 0; i < small.length; i++){
//            int out[i] = getNextElements(big, small[i]);
//        }
//        return out;
//
//    }

    public static int [] getNextElements(int [] big, int elem) {
        int [] out = new int[big.length];
        int pos = -1;
        for(int i = big.length-1; i >=0; i--){
            if(big[i] == elem ){
                pos = i;
            }
            out[i] = pos;
        }
        return out;
    }

    public static int getClosureForIndex(int [][] nextElems, int index){
        int max = -1;
        for(int i =0; i< nextElems.length; i++){
            if(nextElems[i][index] == -1){
                return -1;
            }
            max = Math.max(max, nextElems[i][index]);
        }

        return max;
    }
    public static void main(String[] args) {
        int [] la =  new int []{7,5, 9,0, 2,1,3,5,7,9,1, 1,5,8,4,32,12};
        int []sa = new int[]{1,5, 9};


        System.out.println(findShortestSuperseqenceBruteForce(la, sa));
    }
}

class Range{
    public  int start;
    public int end;
    public Range(int start,int stop){
        this.start = start;
        this.end    = stop;
    }
    public String toString(){
        return String.format("(%d,%d) -> length %d", this.start, this.end, this.length());
    }
    public int length(){
        return Math.abs(end - start +1);
    }

    public boolean shorterThen(Range other){
        return length() < other.length();
    }
}