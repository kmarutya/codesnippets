package com.kmarutyan.interview.misc;

public class SearchRotatedSortedArray {


    public static int search(int v, int [] data){
       return binarySearch(v, data, 0, data.length -1);
    }

    public static int binarySearch(int v, int [] data, int l, int r){
       if ( r < l) return -1;
       int mid = (r + l)/2;

        System.out.println( String.format( "binarySearch(mid = %d, val =%d, l = %d, r = %d)",mid,data[mid], l, r));
       if(data[mid] == v){
           return mid;
       }
       else if(data[mid] < v){
           return binarySearch(v, data, mid+1, r);
        }
        else{
           return  binarySearch(v, data, l, mid-1);
       }
  }



    public static int binarySearchRotated(int v, int [] data, int l, int r){
        if ( r < l) return -1;
        int mid = (r + l)/2;
        System.out.println( String.format( "binarySearch(mid = %d, val =%d, l = %d, r = %d)",mid,data[mid], l, r));

        // check for exact match
        if(data[mid] == v){
            return mid;
        }

        // if pivot point is on the right part of array
        if(data[l] < data[mid]){
            if(v >= data[l] && v < data[mid]){
                return binarySearch(v, data, l, mid-1);
            }
           return  binarySearch(v, data, mid+1,r);
        }

        // pivot is on the left
        if(v <= data[r] && v > data[mid]){
            return binarySearch(v, data, mid+1, r);
        }

        return binarySearch(v, data, l, mid+1);

    }




public static void main(String [] args){

        int [] rotatedData = {  21, 23, 0, 4, 5, 7, 9, 12, 15, 18};
        int [] data = {   0, 4, 5, 7, 9, 12, 15, 18, 21, 23,};
        System.out.println(binarySearchRotated( 5, rotatedData, 0, rotatedData.length -1));

       // System.out.println(search( 145, data));


    }
}
