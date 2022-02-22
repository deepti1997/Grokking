package SlidingWindow;
//https://leetcode.com/problems/maximum-average-subarray-i/
/*Given an array, find the average of all contiguous subarrays of size ‘K’ in it.*/
public class MaxAverageSubArray {
    public static void main(String[] args) {
        MaxAverageSubArray maxAverageSubArray = new MaxAverageSubArray();
        System.out.println(maxAverageSubArray.maxAverageArrImplementation(new int[]{1,12,4,-5,-6,50,3},4));
        //edge cases would be if the array is empty, if the array if size 1, k > size of the array
    }

    public double maxAverageArrImplementation(int[] nums, int k){
        double sum=0.0,maxSum=Integer.MAX_VALUE;

        for(int i = 0; i < k ; i++){
            sum += nums[i];
        }
        maxSum = sum;

        for (int i = k; i<nums.length;i++){
            sum += nums[i];
            sum -= nums[i-k];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum/k;
    }
}
