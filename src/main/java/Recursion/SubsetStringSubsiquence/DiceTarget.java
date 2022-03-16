package Recursion.SubsetStringSubsiquence;

public class DiceTarget {
    public static void main(String[] args) {
        getTarget(4,"");
    }
    public static void getTarget(int target, String ans){
        if(target == 0){
            System.out.println(ans);
            return;
        }
        for(int i=1; i<=6 && i <= target; i++){
            getTarget(target - i, ans+i);
        }
    }
}
