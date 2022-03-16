package Sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{4,2,6,1,7,5};
        bubble(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int arr[], int r ,int c){
        if ( r == 0)
            return;
        if(c < r){
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            System.out.print(arr[c]+",");
            bubble(arr,r,c+1);
        }else{
            System.out.println();
            bubble(arr,r-1,0);
        }
    }
}
