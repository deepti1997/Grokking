package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 12345;
        int digits = (int)(Math.log10(n))+1;
        System.out.println(reverseNumber(n, digits));
    }
    public static int reverseNumber(int n, int digits){
        if(n % 10 == n)
            return n;

        int rem = n % 10;
        return   rem * (int)Math.pow(10,digits-1) + reverseNumber(n/10,digits-1);
    }
}
