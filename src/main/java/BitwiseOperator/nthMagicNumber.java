package BitwiseOperator;

public class nthMagicNumber {
    /* write 1 in binary and take the addition of power of 5
    eg 1 => 0*5^3 + 0*5^2 + 0*5^1 = 5
    2 => 0*5^3 + 1*5^2 + 0*5^1 = 25
     */
    public static void main(String[] args) {
        int n = 6;
        int ans = 0;
        int base  = 5;
        while (n > 0){
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        System.out.println(ans);
    }
}
