package CyclicSort;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number/
/*Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.*/
public class MissingNumbers {
    public static void main(String[] args) {
     //first sort the array
        int[] arr = new int[]{3,1,0};
     sort(arr);
     // iterate through the entire array,  chceck if which number is missing
        int i=0;
        for( i=0;i<arr.length;i++){
            if(arr[i] != i)
               break;
        }
        System.out.println("Missing number "+i);
    }
    public static void sort(int[] arr){
        int temp;
        int i=0;
        while(i < arr.length){
            //if the number is equal to length, ignore it
            int correct = arr[i] == arr.length ? i : arr[i];
            if(arr[i] != arr[correct] ){
                //swap the numbers
                temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else
                i++;
        }
        System.out.println(Arrays.toString(arr));
    }

}
