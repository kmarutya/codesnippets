package com.kmarutyan.interview;

/**
 * Created by apple on 3/25/17.
 */
public class BubbleSort {
    public static int [] bubbleSort(int [] in){
        boolean numberSwitched = false;
        do{
            numberSwitched = false;
            for (int i = 0 ; i < in.length - 1 ; i++){
                int p1 = in[i];
                int p2 = in[i+1];
                if(p1 > p2){
                    //swap
                    in[i] = p2;
                    in[i+1] = p1;
                    numberSwitched = true;
                }
            }
        } while(numberSwitched);

        return in;
    }


    public static void sortAndPrint(int [] in){
        for (int i : bubbleSort(in) ) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }


    public static void main (String [] args){
        sortAndPrint(new int[] {3,4,5,1,5,3,2,9,0,5,6});
        sortAndPrint(new int[] {3});
        sortAndPrint(new int[] {4, 3});
        sortAndPrint(new int[] {3, 4});
        sortAndPrint(new int[] {3, 4,5,6,7 });
        sortAndPrint(new int[] {9,8,7,6,5,4,3,2,1,0 });
    }

}
