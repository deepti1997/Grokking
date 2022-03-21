package CyclicSort;

import java.util.Arrays;

//https://leetcode.com/problems/set-mismatch/
public class SetMismatch {
    public static void main(String[] args) {
        SetMismatch setMismatch = new SetMismatch();
        int[] arr = new int[]{2,3,1,1,4};
        System.out.println(Arrays.toString(setMismatch.findErrorNums(arr)));
    }
    public int[] findErrorNums(int[] nums) {
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }
    public void sort(int[] arr){
        int temp;
        int i=0;
        while(i < arr.length){
            //if the number is equal to length, ignore it
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]){
                //swap the numbers
                temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else
                i++;
        }
    }
}
