package BitwiseOperator;

public class OddOrEven {
    public static void main(String[] args) {
        int n = 20;
        String ans = (n & 1) == 0 ? "Even" : "Odd";
        System.out.println(ans);
    }
}
