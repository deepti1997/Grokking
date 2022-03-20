package CyclicSort;

import java.util.Arrays;

public class CyclicSortInitial {
    public static void main(String[] args) {
         cyclicSort(new int[]{3,2,1,4,5});
    }

    private static void cyclicSort(int[] arr) {
        int temp; int temp2;
        int i =0;
        while( i< arr.length){

            if(arr[i] != i+1){
                temp = arr[i];
                arr[i] =  arr[arr[i]-1];
                arr[temp-1] = temp;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
