package BitwiseOperator;

public class FindIthBit {
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        int mask = 1;
//        for(int i =0;i<k;i++){
//            mask = mask << 1;
//        }
        mask = mask << k-1;
        System.out.println(mask);
        int ans = n & mask;
        System.out.println(ans);
//        for (int i =0;i<k;i++){
//            ans = ans >> 1;
//        }
        ans = ans >> k-1;
        System.out.println(ans);

        System.out.println((n&(1<<(k-1)))>>(k-1));
    }
}
