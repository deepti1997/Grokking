package SlidingWindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/
/*Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.*/

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
    //start with window at first element, have a count of frequency of one - increase if 1 encountered in window, keep a track of 1s in the window
    public static int longestOnes(int[] nums, int k) {
        int winStart=0,windEnd=0,frequencyOfOne=0,maxLength=0;
        for(windEnd=0;windEnd<nums.length;windEnd++){
            if(nums[windEnd] == 1)
                frequencyOfOne++;
            while(windEnd-winStart+1 - frequencyOfOne > k){
                if(nums[winStart] == 1)
                    frequencyOfOne--;
                winStart++;
            }
           maxLength = Math.max(maxLength,windEnd-winStart+1);
        }
        System.out.println(frequencyOfOne);
        return maxLength;
    }
}
