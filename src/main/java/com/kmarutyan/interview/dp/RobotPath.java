package com.kmarutyan.interview.dp;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotPath {


    public static List<Point> findPath(int [][] grid){
        int numRows = grid.length;
        int numCols = grid[0].length;
        List<Point> path = new ArrayList<Point>();
        Set<Point> failedPoints = new HashSet<>();
        findPath(grid, path, failedPoints, numRows-1, numCols-1);
        return path;
    }
    public static boolean inBound(int [][] grid, int r, int c){
        int numRows = grid.length;
        int numCols = grid[0].length;
        return r>=0 && r < numRows && c >= 0 && c< numCols;
    }
    public static String toString(int r, int c){
        return String.format("(%d,%d)", r,c);
    }
    public static List<int[]> getNexMoves(int [][] grid, int row, int col){
       List<int []> moves = new ArrayList<>();
       int [] delta  = {-1, 0, 1};
       for(int dr: delta){
           for(int dc: delta){
               int candRow = row + dr;
               int candCol = col + dc;
               if(inBound(grid, candRow, candCol)){
                   moves.add(new int []{candRow,candCol });
               }
           }
       }

        return moves;
    }

    public static boolean findPath(int [][] grid,  List<Point> path,Set<Point> failedPoints , int r, int c){
       // if out of bounds or not available - return;
        if (!inBound( grid, r,c) )
            return false;

        Point p = new Point(r,c);

        // if already have visited - return
        if (failedPoints.contains(p))
            return false;

        boolean isAtOrigin = ( r== 0 && c ==0);

        if( isAtOrigin || findPath(grid,path, failedPoints, r-1, c )  || findPath(grid,path, failedPoints, r, c -1)){
            path.add(p);
            return true;
        }


        return false;

    }

    public static void main(String... args){
        int [][] grid = {
            {1,1,1,1,0,1,1,0,1,1,1,0},
            {1,1,1,1,0,1,1,0,1,1,1,0},
            {1,1,1,1,0,1,1,0,0,1,1,0},
            {1,1,0,1,0,1,1,1,1,1,0,0},
            {1,1,1,1,0,1,1,1,1,1,1,0},
            {1,1,1,1,1,1,1,0,1,1,1,1},
            {1,0,0,1,0,1,1,0,1,1,1,1},
            {1,1,1,1,1,1,1,0,1,1,1,0},
            {1,1,1,1,1,1,1,1,1,0,1,1},
            {1,1,1,1,0,1,1,1,1,1,1,1}
        };
        List<Point> path = findPath(grid);
        path.stream().forEach(p -> System.out.println(p));
    }
}
