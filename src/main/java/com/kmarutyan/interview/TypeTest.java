package com.kmarutyan.interview;
import java.util.*;
/**
 * Created by apple on 8/19/17.
 */
public class TypeTest {

    public static void main(String []args){
        List<Integer> mergerList = new ArrayList<>();


        List<Integer> mergeList = Arrays.asList(1,34,23,4,2,32);
        mergeList.add(45);
        mergeList.add(4455);
        mergeList.add(23);
        mergeList.add(34);
        mergeList.forEach( a -> System.out.println(a));

        for(int curIndex=0; curIndex < mergeList.size(); curIndex++){

        }

       for (int curIndex = 0; curIndex < mergeList.size(); curIndex++){
            System.out.println(String.format("Current index = %d", curIndex));
       }

        for(int curIndex = 0; curIndex < mergeList.size();  curIndex++){
            System.out.println(curIndex);
        }
    }
}

//
//public static void main(String [] args){
//    System.out.println("");
//System.out.println("My name is Karen);
//
//}