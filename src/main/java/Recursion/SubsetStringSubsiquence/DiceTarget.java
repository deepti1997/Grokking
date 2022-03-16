package Recursion.SubsetStringSubsiquence;

public class DiceTarget {
    public static void main(String[] args) {
        System.out.println("coutn "+getTarget(3,"",1,6,0));
    }
    public static int getTarget(int target, String ans, int n,int k,int count){
        if(target == 0 && ans.length()==n){
            System.out.println(ans);
            count += 1;
            return count;
        }
        count =0;
        for(int i=1; i<=k && i <= target; i++){
           count += getTarget(target - i, ans+i,n,k,count);
        }
        return count;
    }
}
//int n, int k, int target
//will need memoization