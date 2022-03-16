package Recursion.SubsetStringSubsiquence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllSubsets {
    public static void main(String[] args) {
        getSubsetsWord("","abc");
        System.out.println(getSubsetsWord("","abc",new ArrayList<>()));
        //System.out.println(subsets(new int[]{1,2,3});
        int arr[] = new int[] {1,2,3};

        getSubsetsArr(arr);
        getSubsetsArrDups(new int[] {1,2,2});
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

    static List<List<Integer>> getSubsetsArr( int[] up){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());


        for (int num : up) {
            int outerLength = outer.size();
            for(int i=0;i<outerLength;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        System.out.println(outer.toString());
        return outer;

    }
    static List<List<Integer>> getSubsetsArrDups( int[] up){
        Arrays.sort(up);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i =0;i<up.length;i++) {
            start = 0;
            if(i>0 && (up[i] == up[i-1])){
                start = end + 1;
            }
            end = outer.size()-1;
            int outerLength = outer.size();
            for(int j=start;j<outerLength;j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(up[i]);
                outer.add(inner);
            }
        }
        System.out.println(outer.toString());
        return outer;

    }

}
