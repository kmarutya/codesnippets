package com.kmarutyan.interview.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RainWater {

    public static int findMax(int [] grid, int l, int r) {
        if(l < 0 || r > grid.length)
                return -1;

        int max = Integer.MIN_VALUE;
        int maxInd = -1;
        for(int i = l; i <= r; i++ ){
            if(grid[i] > max){
                max = grid[i];
                maxInd = i;
            }
        }

        return maxInd;
    }

    public static int water(int [] grid) {
        return water(grid, 0, grid.length -1);
    }

    public static int waterCalc(int [] grid, int l, int r){
        int totalSum = 0;
        if(l >= r -1)
                return 0;

        int edge = Math.min(grid[l], grid[r]);
        for(int i = l+1; i < r; i++){

            totalSum  = totalSum + (edge - grid[i]);
        }

        totalSum = Math.max(0, totalSum);
        return totalSum;
    }

    public static int water(int [] grid, int l, int r) {
        if (grid == null ){
            return  0;
        }
        int totalSum = 0;

        int maxCenter = findMax(grid, l, r);
        int maxLeft =  (maxCenter <= l + 1)? l : findMax(grid, l, maxCenter -1);
        int maxRight = (maxCenter >= r - 1)? r: findMax(grid, maxCenter+1,r);

        int sumLeft  = (maxLeft == l)?  waterCalc(grid, l, maxCenter) :water(grid, l, maxLeft ) + waterCalc(grid, maxLeft, maxCenter) ;
        int sumRight = (maxRight == r)? waterCalc(grid, maxCenter, r):water(grid, maxRight, r ) + waterCalc(grid, maxCenter, maxRight) ;

        totalSum = sumLeft +  sumRight;

        return totalSum;
    }



    public static int waterStack(int [] grid) {
        int totalSum = 0;

        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            while(!stack.isEmpty() && grid[i] > grid[stack.peek()] ){
                int top = stack.pop();
                if(stack.isEmpty())
                    break;

                int height = Math.min(grid[i] -  grid[top], grid[stack.peek()] - grid[top]);
                int width =  i - stack.peek() - 1;
                totalSum +=  height * width;
            }

            stack.push(i);
        }

        return totalSum;
    }


    public static int bruteForce(int [] grid){
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            int ml = Integer.MIN_VALUE;
            int mr = Integer.MIN_VALUE;
            for(int li = i; li >= 0; li--){
                ml = Math.max(grid[li], ml);
            }
            for(int ri = i; ri < grid.length; ri++){
                mr = Math.max(grid[ri], mr);
            }
            ans += Math.min(mr, ml) - grid[i];
        }

        return ans;
    }



    public static int dp(int [] grid){
        int ans = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int lmax  = 0;
        for(int i = 0; i < grid.length; i++){
            if (lmax < grid[i])
                left.add(0);
            else
                left.add(lmax - grid[i]);

            lmax = Math.max(lmax, grid[i]);

        }

        int rmax  = 0;
        for(int i = grid.length -1 ; i >= 0; i--){
            if (rmax < grid[i])
                right.add(0);
            else
                right.add(rmax - grid[i]);

            rmax = Math.max(rmax, grid[i]);
        }

        for(int i = 0; i < grid.length; i++){
            ans+= Math.min(left.get(i), right.get(i));
        }

        return ans;
    }
    public static void main(String [] args){
//       int[] grid  = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
       int[] grid  =  {1, 3, 2, 4, 1, 3, 1, 4, 5, 2,  2,  1,  4,  2,  2};

//      int[] grid  =  { 5, 2, 4};
//        int[] grid  = {1, 3, 2, 4 ,1, 3};
//
       // System.out.println("Total sum: " + water(grid));
        System.out.println("Total sum: " + waterStack(grid));
        System.out.println("Total sum: " + bruteForce(grid));
        System.out.println("Total sum: " + dp(grid));



    }
}
