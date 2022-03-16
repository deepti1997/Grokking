package Recursion.Backtracking;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean board[][] =  {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathWithObstacles("",0,0,board);
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
}
