package Recursion;

public class CountNumberOf0s {
    public static void main(String[] args) {
        System.out.println(countZero(11000,0));
    }
    static int countZero(int n , int count){
        if(n % 10 == n){
            return count;
        }
        int rem = n % 10;
        if(rem == 0){
            count += 1;
        }
        return countZero(n/10,count);
    }
}
