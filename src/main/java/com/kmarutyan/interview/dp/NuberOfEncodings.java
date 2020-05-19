package com.kmarutyan.interview.dp;

public class NuberOfEncodings {

    public static int nEncodings(String msg){
       int n=msg.length();

       return nEncodings(msg, n-1);
    }

    public static int nEncodings(String msg, int pos){
        if(pos==0)
            return 1;
        if(pos < 0)
            return 0;

        int ans = nEncodings(msg, pos - 1) + 1;
        int candEncode = Character.getNumericValue(msg.charAt(pos -1)*10 + Character.getNumericValue(msg.charAt(pos)));
        if(candEncode < 27)
        ans =  ans + 1;
        return ans;


    }

    public static void main(String[] args) {
        System.out.println(nEncodings("1261"));
    }
}
