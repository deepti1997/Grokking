package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {2,6,1,7,4,5,8,3};
        System.out.println(Arrays.toString(mergeSort(new int[] {2,6,1,7,4,5,8,3})));
        mergeSortInplace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    //by creating new copies of the array parts
    public static int[] mergeSort(int[] nums){
        if(nums.length == 1)
            return nums;
        
        int mid = nums.length / 2;
        int left[] = mergeSort(Arrays.copyOfRange(nums,0,mid));
        int right[] = mergeSort(Arrays.copyOfRange(nums,mid,nums.length));
        
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j=0,k=0;
        int [] mix = new int[left.length + right.length];
        while (i < left.length && j < right.length){
            if(left[i] <= right[j]){
                mix[k] = left[i];
                i++;
            }else{
                mix[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }
        return mix;
    }

    //inplace sorting
    public static void mergeSortInplace(int[] nums, int start, int end){
        if(end - start == 1)
            return ;

        int mid = (start + end) / 2;
        mergeSortInplace(nums,start,mid);
        mergeSortInplace(nums,mid,end);

        mergeInplace(nums,start,mid,end);
    }
    private static void mergeInplace(int[] nums, int start, int mid, int end) {
        int i = start, j=mid,k=0;
        int [] mix = new int[end - start];
        while (i < mid && j < end){
            if(nums[i] <= nums[j]){
                mix[k] = nums[i];
                i++;
            }else{
                mix[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i < mid){
            mix[k] = nums[i];
            i++;
            k++;
        }
        while(j < end){
            mix[k] = nums[j];
            j++;
            k++;
        }
        for (int l = 0 ; l<k ;l++){
            nums[start+l] = mix[l];
        }
    }
}
