package TwoPointer;
//https://leetcode.com/problems/sort-colors/
/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]*/
public class SortColors {
    public static void main(String[] args) {
        //sortColors(new int[] {2,0,2,1,1,0});
        sortColors1(new int[] {2,0,2,1,1,0});
    }
    //count sort
    public static void sortColors(int[] nums) {
        int countArr[] = new int[3];
        for ( int i=0;i< nums.length ; i++){
            if(nums[i] == 0)
                countArr[0]++;
            else if(nums[i] == 1)
                countArr[1]++;
            else
                countArr[2]++;
        }
        for(int i=0;i<countArr[0];i++)
            nums[i] = 0;
        for(int j=countArr[0];j<countArr[0]+countArr[1];j++)
            nums[j] = 1;
        for (int k=countArr[0]+countArr[1];k< nums.length;k++)
            nums[k] = 2;

        for (int i = 0;i< nums.length;i++)
            System.out.print(nums[i]+",");
    }
    //dutch flag algorithm
    public static void sortColors1(int[] nums) {
        int low=0;int high= nums.length-1;int mid=0;
        while(mid <= high){
            if(nums[mid] == 0){
                swapElems(low,mid,nums);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swapElems(mid,high,nums);
                high--;
            }
        }
        for (int i=0;i<nums.length;i++)
            System.out.print(nums[i]+",");
    }

    public static void swapElems(int a,int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
