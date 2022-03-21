package CyclicSort;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {7,6,3,1,2}));
    }
    public int firstMissingPositive(int[] nums) {
        boolean[] saw = new boolean[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] <= nums.length + 1) {
                saw[nums[i]] = true;
            }
        }
        for (int i = 1; i < saw.length; i++) {
            if (!saw[i]) {
                return i;
            }
        }
        return -1;
    }
}
