package TwoPointer;

import java.util.Arrays;

public class ThreeSumSmallest {
    public static void main(String[] args) {
        System.out.println(threeSumSmallest(new int[]{-1,-1,2,1,-4},-2));
    }
    public static int threeSumSmallest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int solution = 0;
        for (int i=0;i< nums.length-2;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = target - nums[i];
            while (j < k && j < nums.length) {
                int currentDiff = sum - nums[j] - nums[k];
                if(currentDiff > 0 && currentDiff < minDiff){
                    minDiff = currentDiff;
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
