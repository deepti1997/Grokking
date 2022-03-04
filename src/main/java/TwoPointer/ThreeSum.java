package TwoPointer;

import java.util.*;
//https://leetcode.com/problems/3sum/
/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]*/
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // do a two pointer on the remaining elements. to do that we keep a counter k, which will become equal to len-1 with every iteration of i
        for(int i=0;i< nums.length-2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int k = nums.length - 1;
                int j = i + 1;
                int sum = 0 - (nums[i]);
                while (j < k) {
                    if (nums[j] + nums[k] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j<k && (nums[j] == nums[j+1])) j++;
                        while(j<k && (nums[k] == nums[k-1])) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] > sum)
                        k--;
                    else if (nums[j] + nums[k] < sum)
                        j++;
                }
            }
        }
        return ans;
    }

}
