package BitwiseOperator;

public class NonDupNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1,3,4,2,1,5};
        int ans = 0;
        for(int i=0;i< arr.length;i++){
            ans = ans ^ arr[i];
        }
        System.out.println(ans);
    }

}
