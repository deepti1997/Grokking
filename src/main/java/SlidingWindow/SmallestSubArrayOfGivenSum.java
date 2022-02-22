package SlidingWindow;

//https://leetcode.com/problems/minimum-size-subarray-sum/
/*Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.

Return 0 if no such subarray exists.*/
public class SmallestSubArrayOfGivenSum {
    public static void main(String[] args) {
        SmallestSubArrayOfGivenSum smallestSubArrayOfGivenSum = new SmallestSubArrayOfGivenSum();
        System.out.println(smallestSubArrayOfGivenSum.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums){
        //start with the the window at 0, keep increasing the window size till we get sum greater than target, compare ans save the minimum size
        //here we use the concept of dynamic sizing of the window
        int winStart = 0, winEnd = 0, minLength = Integer.MAX_VALUE, sum = 0;
        for(winEnd=0;winEnd< nums.length;winEnd++){
            sum += nums[winEnd];
            while(sum >= target){
                minLength = Math.min(minLength,winEnd-winStart+1);
                sum -= nums[winStart];
                winStart++;
            }
        }
        return minLength;
    }

}
