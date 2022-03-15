package Recursion;

public class CheckIfArraySorrted {
    public static void main(String[] args) {
        System.out.println(sorted(new int[]{1,3,5,4,7,8},0));
    }
    public static boolean sorted(int[] arr, int index){
        if( index == arr.length - 1)
            return  true;

        return arr[index] <= arr[index+1] && sorted(arr,index+1);
    }
}
