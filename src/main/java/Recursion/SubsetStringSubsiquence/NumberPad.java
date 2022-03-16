package Recursion.SubsetStringSubsiquence;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number

/* Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]*/

import java.util.ArrayList;
import java.util.List;

public class NumberPad {
    public static void main(String[] args) {
           // printCombinations("","12");
        System.out.println(printCombinations1("","92"));
    }
    static void printCombinations(String proc, String unProc){
        if(unProc.length() == 0){
            System.out.println(proc);
            return;
        }
        int digit = (int)(unProc.charAt(0) - '0');
        for(int i=(digit-1)*3 ; i<digit*3;i++){
            char toAdd = (char)(i + 'a');
            printCombinations(proc+toAdd,unProc.substring(1));
        }
    }
    static List<String> printCombinations1(String proc, String unProc){
        List<String> local = new ArrayList<>();
        if(unProc.length() == 0){
            local.add(proc);
            return local;
        }
        int digit = (int)(unProc.charAt(0) - '0');
        int post=0;int pre=0;
        if(digit >= 7)
            if(digit==7)
                post = 1;
            else if(digit == 8){
                pre = 1;
                post = 1;
            }
            else if(digit == 9){
                pre = 1;
                post = 2;
            }

        digit = digit -1 ;
        for(int i=(digit-1)*3 + pre ; i<digit*3+post;i++){
            char toAdd = (char)(i + 'a');
            local.addAll(printCombinations1(proc+toAdd,unProc.substring(1)));
        }
        return local;
    }
}
