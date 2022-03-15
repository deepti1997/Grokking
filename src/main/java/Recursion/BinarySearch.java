package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{2,4,6,7,9},4,0,4));
    }
    static int search(int[] arr, int target, int start, int end){
        if(start > end)
            return -1;

        int mid = start + (end - start)/2;
        if(target == arr[mid])
            return mid;
        else if( target < arr[mid])
            return search(arr,target,start,mid-1);

        return search(arr, target, mid+1, end);
    }
}
