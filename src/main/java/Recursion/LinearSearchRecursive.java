package Recursion;

public class LinearSearchRecursive {
    public static void main(String[] args) {
        System.out.println(find(new int[]{2,5,1,3,6,8},2,0));
        System.out.println(findIndex(new int[]{2,5,1,3,6,8},9,0));
    }

    static boolean find(int[] arr, int target, int index){
        if( index == arr.length)
            return false;
        return arr[index] == target || find(arr,target,index+1);
    }

    static int findIndex(int[] arr, int target, int index){
        if( index == arr.length)
            return -1;
        if (arr[index] == target)
            return index;
        else
            return findIndex(arr,target,index+1);
    }
}
