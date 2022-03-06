package TwoPointer;

//https://leetcode.com/problems/3sum-closest/
/*Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

import java.util.Arrays;

public class TheeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,-1,2,1,-4},5));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int solution = 0;
        for (int i=0;i< nums.length-2;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = target - nums[i];
            while (j < k && j < nums.length) {
                int currentDiff = sum - nums[j] - nums[k];
                int absDiff = Math.abs(currentDiff);
                if(absDiff < minDiff){
                    minDiff = absDiff;
                    solution = nums[i] + nums[j] + nums[k];
                }
                if (currentDiff == 0)
                    return target;
                else if (currentDiff > 0)
                    j++;
                else
                    k--;
            }
        }
        return solution;
    }
}
