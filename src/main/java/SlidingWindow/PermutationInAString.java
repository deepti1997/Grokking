package SlidingWindow;
//https://leetcode.com/problems/permutation-in-string/
/*Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.*/

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("dc","dcda"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        //the size of the window is equal to size of s1
        //populate the array of size 26 ( if only letters) of both s1 and s2
        int s1Frequency[] = new int[26];
        int s2Frequency[] = new int[26];
        for(int i= 0;i<s1.length();i++){
            s1Frequency[s1.charAt(i) - 'a']++;
            s2Frequency[s2.charAt(i) - 'a']++;
        }
        int k = s1.length();
        for(int winStart=0;winStart<s2.length()-k;winStart++){
            //check if the maps are matching
            if(matches(s1Frequency,s2Frequency))
                return true;
            s2Frequency[s2.charAt(winStart) - 'a' ]--;
            s2Frequency[s2.charAt(winStart + k) - 'a']++;
        }//trying to match the last window
        return matches(s1Frequency,s2Frequency);
    }
    public static boolean matches(int[] s1Frequency, int[]s2Frequency){
        for(int i=0;i<26;i++){
            if(s1Frequency[i] != s2Frequency[i])
                return false;
        }
        return true;
    }
}
