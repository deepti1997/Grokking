package Recursion.SubsetStringSubsiquence;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        permutionOfString("","abc");
        permutionOfStringSave("","abc");
        System.out.println(ans.toString());
        System.out.println(permutionOfStringSave1("","abc"));
    }
    static void permutionOfString(String proc,String unProc){
        if(unProc.length() == 0){
            System.out.println(proc);
            return;
        }

        char ch = unProc.charAt(0);
        for(int i=0;i<=proc.length();i++){
            String s = proc.substring(0,i) + ch + proc.substring(i,proc.length());
            permutionOfString(s,unProc.substring(1));
        }
    }
    static List<String> ans = new ArrayList<>();
    static void permutionOfStringSave(String proc,String unProc){
        if(unProc.length() == 0){
            ans.add(proc);
            return;
        }

        char ch = unProc.charAt(0);
        for(int i=0;i<=proc.length();i++){
            String s = proc.substring(0,i) + ch + proc.substring(i,proc.length());
            permutionOfStringSave(s,unProc.substring(1));
        }
    }

    static List<String> permutionOfStringSave1(String proc,String unProc){
        List<String> local = new ArrayList<>();
        if(unProc.length() == 0){
            local.add(proc);
            return local;
        }

        char ch = unProc.charAt(0);
        for(int i=0;i<=proc.length();i++){
            String s = proc.substring(0,i) + ch + proc.substring(i,proc.length());
            local.addAll(permutionOfStringSave1(s,unProc.substring(1)));
        }
        return local;
    }
}
