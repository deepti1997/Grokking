package Recursion.Backtracking;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        path("",3,3);
    }
    //no of steps required to go from 0,0 to 3,3
    static int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left = count(r-1,c);
        int right = count(r,c-1);
        return left+right;
    }

    //print the path required to reach 3,3 from 0,0
    static void path(String str,int r,int c){
        if(r ==1 && c==1){
            System.out.println(str);
            return;
        }
        if( r > 1)
            path(str+'D',r-1,c);
        if( c > 1)
            path(str+'R',r,c-1);
    }
}
