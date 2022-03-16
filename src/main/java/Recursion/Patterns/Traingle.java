package Recursion.Patterns;

public class Traingle {
    public static void main(String[] args) {
        printPattern(4,0);
        printPattern1(4,0);
    }
// bubble sort is inspired by this
    static void printPattern(int r, int c){
        if(r == 0)
            return;
        if(c < r){
            System.out.print(" * ");
            printPattern(r,c+1);
        }else{
            System.out.println();
            printPattern(r-1,0);
        }
    }
    static void printPattern1(int r, int c){
        if(r == 0)
            return;
        if(c < r){
            printPattern1(r,c+1);
            System.out.print(" * ");
        }else{
            printPattern1(r-1,0);
            System.out.println();
        }
    }
}
