package Recursion.SubsetStringSubsiquence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllSubsets {
    public static void main(String[] args) {
        getSubsetsWord("","abc");
        System.out.println(getSubsetsWord("","abc",new ArrayList<>()));
       // System.out.println(subsets(new int[]{1,2,3});
    }
    static void getSubsetsWord(String p, String up){
        if(up.length() == 0){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        getSubsetsWord(p+ch,up.substring(1));
        getSubsetsWord(p,up.substring(1));
    }
    static ArrayList<String> getSubsetsWord(String p, String up, ArrayList<String> ans){
        if(up.length() == 0){
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);

        ans =  getSubsetsWord(p+ch,up.substring(1), ans);
        ans =  getSubsetsWord(p,up.substring(1),ans);

        return ans;
    }


}
