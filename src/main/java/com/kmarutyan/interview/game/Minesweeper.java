package com.kmarutyan.interview.game;

enum TYPE {BOMB, BLANK, NUMBER};
class Cell {
    int row;
    int col;
    int val;
    TYPE type = TYPE.BLANK;
    boolean isExposed = false;
    boolean isGuess = false;

    public boolean isBomb(){
        if(type == TYPE.BOMB)
            return true;
        return false;
    }
    public boolean flip(){
        isExposed = true;
       return !isBomb();
    }
    public boolean toggleGuess(){
        if(!isExposed)
            isGuess = !isGuess;
        return isGuess;
    }
}
class Board{
    int numRows, numCols, numBombs;
    int Cell[][];

    public void initalizeBoard(){}
}
public class Minesweeper {

}
