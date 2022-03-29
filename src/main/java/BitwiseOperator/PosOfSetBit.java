package BitwiseOperator;

public class PosOfSetBit {
    public static void main(String[] args) {
    // find the position of the rightmost set bit
        int n = 16;
        int i =1;
        while( (n & 1) != 1){
            n = n >> 1;
            i++;
        }
        System.out.println(i);
    }
}
