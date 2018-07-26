package com.kmarutyan.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CircusTower {

    static List<HtWt> longestIncreasingSeq(List<HtWt> items){
        Collections.sort(items);
        return bestSeqAtIndex(items, new ArrayList<HtWt>(), 0);

    }
    static List<HtWt> bestSeqAtIndex(List<HtWt> items, List<HtWt> sequence, int index){
        if(index >= items.size())
            return sequence;
        HtWt item = items.get(index);
        List<HtWt> bestWith = null;
        if(canAppend(sequence, item)){
            List<HtWt> sequenceWith = new ArrayList<>(sequence);
            sequenceWith.add(item);
            bestWith = bestSeqAtIndex(items, sequenceWith, index+1  );
        }
        List<HtWt> bestWithout = bestSeqAtIndex(items, sequence, index+1);
        return maxSeq(bestWith, bestWithout);

    }
   static  boolean canAppend(List<HtWt> items, HtWt item){
        if(items == null)
            return false;
        if(items.isEmpty())
            return true;

        HtWt lastItem =items.get(items.size() - 1);
        return lastItem.isBefore(item);

    }

    static List<HtWt> maxSeq(List<HtWt> seq1, List<HtWt> seq2){
        if(seq1 == null)
            return seq2;
        if(seq2 == null)
            return seq1;
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

        public static void main(String... args){

        List<HtWt> list = Arrays.asList(
                 new HtWt (160, 55),
                 new HtWt (162, 58),
                 new HtWt (190, 90),
                 new HtWt (170, 55),
                 new HtWt (172, 70),
                 new HtWt (190, 90),
                 new HtWt (180, 94)
                );
        List<HtWt> bestList = longestIncreasingSeq(list);
        bestList.forEach(l -> System.out.println(l.toString()));
    }
}

class HtWt implements Comparable<HtWt>{
    int height;
    int weight;
    public HtWt(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return String.format("Height %d, weight %d",height, weight);
    }

    @Override
    public int compareTo( HtWt that){
      if(this.height != that.height){
          return ( this.height - that.height);
      }
      else{
          return (this.weight - that.weight);
      }
    }

    public boolean isBefore(HtWt that){
        if(this.height < that.height && this.weight < that.weight )
            return true;
        else
            return false;
    }
}