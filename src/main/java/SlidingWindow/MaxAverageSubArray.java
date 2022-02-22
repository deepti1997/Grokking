package SlidingWindow;
//https://leetcode.com/problems/maximum-average-subarray-i/
/*Given an array, find the average of all contiguous subarrays of size ‘K’ in it.*/
public class MaxAverageSubArray {
    public static void main(String[] args) {
        MaxAverageSubArray maxAverageSubArray = new MaxAverageSubArray();
        System.out.println(maxAverageSubArray.maxAverageArrImplementation(new int[]{1,12,4,-5,-6,50,3},4));
        //edge cases would be if the array is empty, if the array if size 1, k > size of the array

        //maxAverageArrImplementation is less time consuming that maxAverageArrImplementation1 , as we are reducing the number of comparisons
        System.out.println(maxAverageSubArray.maxAverageArrImplementation1(new int[]{1,12,4,-5,-6,50,3},4));
    }

     double maxAverageArrImplementation(int[] nums, int k){
        double sum=0.0,maxSum=Integer.MIN_VALUE;

        for(int i = 0; i < k ; i++){ //here i is the end of the window
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
     double maxAverageArrImplementation1(int[] nums,int k){
        int winStart=0,winEnd=0;
        double sum=0.0, maxSum = Integer.MIN_VALUE;
        for(winEnd=0;winEnd < nums.length ; winEnd++){
            sum += nums[winEnd];
            if(winEnd >= k){
                sum -= nums[winStart];
                winStart++;
                maxSum = Math.max(maxSum,sum);
            }
        }
        return maxSum/k;
     }

}
