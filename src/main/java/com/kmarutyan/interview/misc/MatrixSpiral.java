package com.kmarutyan.interview.misc;



import java.util.Arrays;

public class MatrixSpiral {
    public final static String LEFT = "LEFT";
    public final static String RIGHT = "RIGHT";
    public final static String DOWN = "DOWN";
    public final static String UP = "UP";


    public static int [] flatten(int [][] data){
        int numRows = data.length;
        int numCols = data[0].length;
        int nTotal = numRows * numCols;
        int [][] visits  = new int[numRows][numCols];

        int [] flatten = new int[nTotal];

        int col = 0;
        int row = 0;
        int visited = 0;
        String direction  = RIGHT;

        while(visited < nTotal ){
            System.out.println(String.format("%s (%d,%d ))" ,direction,row, col));
            if(row >=0 && row < numRows && col >=0 && col < numCols && visits[row][col] == 0 ){
                System.out.println(String.format("%s (%d,%d )=%d -> %d of(%d)" ,direction,row, col, data [row][col], visited, flatten.length));
                flatten[visited] = data [row][col];
                visits[row][col] = 1;
                visited++;
            }
            // check next
            switch (direction){
                case RIGHT: {
                    if( col + 1 == numCols || visits[row][col + 1] > 0){
                        direction = DOWN;
                        row++;
                    }
                    else
                        col++;
                }
                break;
                case DOWN: {
                    if(row + 1  == numRows || visits[row+1][col] > 0){
                        direction = LEFT;
                        col--;
                    }
                    else
                        row++;
                    break;
                }
                case LEFT: {
                    if(col -1 < 0 || visits[row][col -1]> 0){
                        direction = UP;
                        row--;
                    }
                    else
                        col--;
                    break;
                }
                case UP: {
                    if(row -1  < 0 || visits[row-1][col] > 0 ){
                        direction = RIGHT;
                        col++;
                    }
                    else
                        row --;
                    break;
                }
            }
            System.out.println(Arrays.toString(flatten));


        }

        return flatten;
    }


    public static void main(String[] args) {
        int [][] data =  new int [][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(Arrays.toString(flatten(data)));
    }
}
