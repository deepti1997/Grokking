package Recursion;
//print the nth number in the fibonaci series

public class FibonaciSeries {
    public static void main(String[] args) {
        System.out.println(printFibonacci(6));
    }
    static int printFibonacci(int n){
        if( n == 0 ){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int sum =  printFibonacci(n-1)+printFibonacci(n-2);
        return sum;
    }
}
