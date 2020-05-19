package com.kmarutyan.interview.dp;

import java.util.Arrays;

public class UniquePassInGrid {


    public static int uniquePathInGrid(int [][] grid){
        int numRow = grid.length;
        int numCol = grid[0].length;
        int [][] memo = new int [numRow][numCol];
        for(int [] row: memo) Arrays.fill(row, -1);
        int ans  = uniquePathInGrid(grid,  memo,  numRow-1, numCol -1);
        return ans;
    }

    public static int uniquePathInGrid(int[][] grid, int [][] memo, int r, int c){
        if(r < 0 || c < 0 )
            return 0;
        if(grid [r][c] == 1 )
            return 0;
        if(r == 0  && c == 0)
            return 1;

        if( memo[r][c] >= 0) return memo[r][c];
        int cand1 = uniquePathInGrid(grid, memo,r-1, c);
        int cand2 = uniquePathInGrid(grid,memo, r, c-1);
        int ans = cand1 + cand2;
        memo[r][c] = ans;
        System.out.println(String.format("r =%d, c= %d, ans = %d", r, c, ans));

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(uniquePathInGrid (
                        new int [][]{
                                {0,0,0},
                                {0,1,0},
                                {0,0,0},
                        }
                )
        );
    }
}
