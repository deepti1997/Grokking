package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board  =new boolean[n][n];
        List<List<String>> solution = new ArrayList<>();
        System.out.println(queens(board,0,solution));
        System.out.println(solution);

    }
    static int queens(boolean[][] board, int row,List<List<String>> solution){
        if(row == board.length){
            display(board);
            populateList(board,solution);
            System.out.println();
            return 1;
        }
        int count = 0;
        for(int i=0;i<board.length;i++){
            if (isSafe(board,row,i)){
                //place the queen
                board[row][i] = true;
                count += queens(board,row+1,solution);
                board[row][i] = false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][]board,int row,int col){
        //check for vertical, id any other queen is there
        for(int i=0;i<=row;i++){
            if(board[i][col])
                return false;
        }
        //check right diagonal
        int rightSteps = Math.min(row,board.length-1-col);
        for(int i=1;i<=rightSteps;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        //check left diagonal
        int leftStep = Math.min(row,col);
        for(int i=1;i<=leftStep;i++){
            if(board[row-i][col-i])
                return false;
        }
        return true;
    }
    static void display(boolean[][] board){
        for (boolean[] row : board){
            for(boolean element : row){
                if(element)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }

    static void populateList(boolean[][] board,List<List<String>> solution){
        List<String> inner = new ArrayList<>();
        for (boolean[] row : board){
            String onePath = "";
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                    onePath += "Q";
                }
                else {
                    System.out.print("X ");
                    onePath += ".";
                }
            }
            inner.add(onePath);
            System.out.println();
        }
        solution.add(inner);
    }
}
