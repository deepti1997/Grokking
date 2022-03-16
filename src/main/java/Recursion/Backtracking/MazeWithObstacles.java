package Recursion.Backtracking;

import java.util.Arrays;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean board[][] =  {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
      //  pathWithObstacles("",0,0,board);
       // pathAll("",0,0,board);
        pathAllPrint("",0,0,board,1,new int[board.length][board[0].length]);
    }
    static void pathWithObstacles(String str,int r,int c,boolean[][] maze){
        if(r == maze.length -1  && c==maze[0].length -1 ){
            System.out.println(str);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if( r < maze.length -1 )
            pathWithObstacles(str+'D',r+1,c,maze);
        if( c <maze[0].length -1 )
            pathWithObstacles(str+'R',r,c+1,maze);
    }

    static void pathAll(String str,int r,int c,boolean[][] maze){
        if(r == maze.length -1  && c==maze[0].length -1 ){
            System.out.println(str);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        if( r < maze.length -1 ){
            pathAll(str+'D',r+1,c,maze);

        }
        if( c <maze[0].length -1 ){
            pathAll(str+'R',r,c+1,maze);
        }
        if( r > 0 ) {
            pathAll(str + 'U', r - 1, c, maze);
        }
        if( c > 0 ) {
            pathAll(str + 'L', r, c - 1, maze);
        }
        maze[r][c] = true;
    }
    static void pathAllPrint(String str,int r,int c,boolean[][] maze,int step,int[][] path){
        if(r == maze.length -1  && c==maze[0].length -1 ){
            path[r][c] = step;
            System.out.println(str);
            for (int[] arr : path)
                System.out.println(Arrays.toString(arr));
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if( r < maze.length -1 ){
            pathAllPrint(str+'D',r+1,c,maze,step+1,path);

        }
        if( c <maze[0].length -1 ){
            pathAllPrint(str+'R',r,c+1,maze,step+1,path);
        }
        if( r > 0 ) {
            pathAllPrint(str + 'U', r - 1, c, maze,step+1,path);
        }
        if( c > 0 ) {
            pathAllPrint(str + 'L', r, c - 1, maze,step+1,path);
        }
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
