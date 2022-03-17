package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NKnights {

    public static void main(String[] args) {
        int n = 2;
        boolean[][] board  =new boolean[n][n];
       // List<List<String>> solution = new ArrayList<>();
        nknight(board,0,0,2);
       // System.out.println(solution);
    }
    static void nknight(boolean[][] board,int row,int col,int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length)
            return;
        if(col == board.length){
            nknight(board,row+1,0,knights);
            return;
        }
        if(isSafe(board,row,col)){
            board[row][col] = true;
            nknight(board,row,col+1,knights-1);
            board[row][col] =false;
        }
        nknight(board,row,col+1,knights);
    }
    static void display(boolean[][] board){
        for (boolean[] row : board){
            for(boolean element : row){
                if(element)
                    System.out.print("K ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][]board,int row,int col){
        if(isValid(board,row-2,col-1)){
            if(board[row -2][col -1])
                return false;
        }
        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2])
                return false;
        }
        if(isValid(board,row -2,col + 1)){
            if(board[row -2][col +1 ])
                return false;
        }
        if(isValid(board,row -1 ,col+2)){
            if(board[row-1][col+2])
                return false;
        }
        return true;
    }
    static boolean isValid(boolean[][]board,int row,int col){
        if(row>=0 && row < board.length && col >=0 && col < board.length){
            return true;
        }
        return false;
    }
}
