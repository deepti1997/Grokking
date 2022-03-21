package CyclicSort;

import java.util.Arrays;

public class RepeatedNumberCyclic {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        sort(arr);
        findDuplicate(arr);

    }
    //using cyclic sort
    public static void sort(int[] arr){
        int temp;
        int i=0;
        while(i < arr.length){
            //if the number is equal to length, ignore it
            if(arr[i] != i+1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    //swap the numbers
                    temp = arr[i];
                    arr[i] = arr[correct];
                    arr[correct] = temp;
                } else {
                    System.out.println(arr[i]);
                    break;
                }
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //using the fast and slow pointer technique
    public static void findDuplicate(int[] nums){
        //do a fast slow pointer till we find where slow == fast
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast );

        //finding the first node of the cycle
        if(slow == fast) {
            slow = nums[0];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            System.out.println(fast);
        }else{
            System.out.println(-1);
        }
    }
}
