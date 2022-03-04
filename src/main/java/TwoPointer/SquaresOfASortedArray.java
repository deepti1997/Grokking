package TwoPointer;
//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int ans[] = sortedSquares(new int[] {-4,-1,0,3,10});
        for(int i=0;i< ans.length;i++){
            System.out.print(ans[i]+",");
        }
    }
    public static int[] sortedSquares(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        int ans[]  = new int[nums.length];
        for(int k = nums.length-1;k>=0;k--){
            if(Math.abs(nums[i]) >= Math.abs(nums[j])){
                ans[k] = nums[i] * nums[i];
                i++;
            }else{
                ans[k] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }
}

