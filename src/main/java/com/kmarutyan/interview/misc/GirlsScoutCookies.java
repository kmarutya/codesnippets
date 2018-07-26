package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class GirlsScoutCookies {

    public static int [] mergeCookies(int []c1, int c2[]){
        // sanity check
        if (c1 == null || c1.length == 0 )
            return c2;
        if (c2 == null || c2.length == 0)
            return c1;

        int [] anws = new int [c1.length  + c2. length ];

        int li = 0, ri =0;int i = 0;

        while( li < c1.length && ri < c2.length  ){
//            System.out.println(String.format("li %d,  ri %d, i %d", li, ri, i));
            if(c1[li] <= c2[ri]){
                anws[i] = c1[li];
                li++;
                i++;
            }
            else{
                anws[i] = c2[ri];
                ri++;
                i++;
            }
//            System.out.println(String.format("li %d,  ri %d, i %d", li, ri, i));
//            System.out.println(Arrays.toString(anws));
//            System.out.println();

        }

//        System.out.println(String.format("li = %d, ri = %d", li, ri));
        if(li <  c1.length -1)
            System.arraycopy( c1, li, anws, i+1, c1.length - li );

        if(ri <  c1.length -1)
            System.arraycopy( c2, ri, anws, i, c2.length - ri);

        return anws;

    }

    public static void main(String [] args){

        int [] cookies1 = {3, 4, 6, 10, 11, 15};
        int [] cookies2 = {1, 5, 8, 12, 16, 19};

        System.out.println(Arrays.toString(mergeCookies(cookies1, cookies2)));
    }
}
