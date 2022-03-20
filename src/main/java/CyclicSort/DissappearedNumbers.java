package CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/

public class DissappearedNumbers {
    public static void main(String[] args) {
        //sort the array
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        sort(arr);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            if(arr[i] != i+1 )
                ans.add(i+1);
        }
        System.out.println(ans.toString());
    }
    public static void sort(int[] arr){
        int temp;
        int i=0;
        while(i < arr.length){
            //if the number is equal to length, ignore it
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct] && arr[i] != arr[correct] ){
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
