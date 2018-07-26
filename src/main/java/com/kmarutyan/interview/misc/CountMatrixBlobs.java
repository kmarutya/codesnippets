package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class CountMatrixBlobs {

    public static int countBlobs(int [][] m){
        if( m == null)
            return 0;
        int numRows = m.length;
        int numCols = m[0].length;
        int visited [][] = new int [numRows][numCols];

        int count = 0;
        for(int r = 0; r < numRows; r++){
            for (int c = 0; c< numCols; c++){
                if (m[r][c] == 1 && visited[r][c] == 0) // unvisited black cell
                {
                    markVisited(r,  c,  m, visited);
                    count++;
                    System.out.println(count + ": " + arr2str(visited));
                }
            }
        }
        return count;
    }

    public static void markVisited(int r, int c, int[][] m, int [][] visited){
        int numRows = m.length;
        int numCols = m[0].length;

        if(r < 0 || r >= numRows)
            return;
        if(c < 0 || c >= numCols)
            return;
        if(visited[r][c] == 1)
            return;
        if(m[r][c] == 0)
            return;

        visited[r][c] = 1;
        markVisited(r-1, c, m, visited);
        markVisited(r+1, c, m, visited);
        markVisited(r, c-1, m, visited);
        markVisited(r, c+1, m, visited);

    }

    public static String arr2str (int [][] matrix){
        StringBuilder sb= new StringBuilder();
        for(int [] m : matrix){
            sb.append(Arrays.toString(m)).append("\n");
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        int[][] m =
                {
                        {0, 0, 0, 1, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1},
                        {0, 0, 1, 1, 1}
                };
        System.out.println(countBlobs(m));
    }
}
