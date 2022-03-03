package TwoPointer;
/*https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(ans[0]+","+ans[1]);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int startPointer = 0;
        int endPointer = numbers.length - 1;
        int ans[] = new int [2];
        while (startPointer < endPointer){
            int sum = numbers[startPointer] + numbers[endPointer];
            if(sum == target){
                ans[0] = startPointer+1;
                ans[1] = endPointer+1;
                break;
            }
            else if(sum > target)
                endPointer--;
            else if(sum < target)
                startPointer++;
        }
        return ans;
    }
}
