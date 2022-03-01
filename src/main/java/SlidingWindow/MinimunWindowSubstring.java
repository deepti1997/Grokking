package SlidingWindow;
//https://leetcode.com/problems/minimum-window-substring/
/*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
"cabwefgewcwaefgcf"
"cae"
A substring is a contiguous sequence of characters within the string.*/

import java.util.HashSet;
import java.util.Set;

public class MinimunWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf","ccae"));

    }

//    public static String minWindow(String s, String t){
//        String ans = "";
//        if(t.length() > s.length())
//            return ans;
//        int[] sMap = new int[100];
//        int[] tMap = new int[100];
//        for(int i=0; i < t.length();i++) {
//            sMap[s.charAt(i) - 'A']++;
//            tMap[t.charAt(i) - 'A']++;
//        }
//        if(isSubString(sMap,tMap,t))
//            return s.substring(0,t.length());
//
//        int startPointer = t.length(), endPointer = t.length(),minLength=Integer.MAX_VALUE;
//        while (endPointer < s.length()){
//            sMap[s.charAt(endPointer) - 'A']++;
//            while (isSubString(sMap,tMap,t)){
//                if(endPointer-startPointer+1 < minLength){
//                    ans = s.substring(startPointer,endPointer+1);
//                    minLength = endPointer-startPointer+1;
//                }
//                sMap[s.charAt(startPointer) - 'A']--;
//                startPointer++;
//                while(startPointer<s.length() && tMap[s.charAt(startPointer) - 'A'] == 0){
//                    sMap[s.charAt(startPointer) - 'A']--;
//                    startPointer++;
//                }
//            }
//            endPointer++;
//        }
//
//        return ans;
//    }

    public static String minWindow(String s, String t) {
        String ans = "";
        if(t.length() > s.length())
            return ans;
        int[] sMap = new int[100];
        int[] tMap = new int[100];
        Set<Character> st = new HashSet<>();
        for(int i=0; i < t.length();i++) {
//            sMap[s.charAt(i) - 'A']++;
            st.add(t.charAt(i));
            tMap[t.charAt(i) - 'A']++;

        }
        if(isSubString(sMap,tMap,t))
            return s.substring(0,t.length());
        int letters =0;
        int startPointer = 0;
        int endPointer = 0;
        int smallest = Integer.MAX_VALUE;
        while (endPointer < s.length()){
            char end = s.charAt(endPointer);
            sMap[s.charAt(endPointer) - 'A']++;
            if(sMap[s.charAt(endPointer) - 'A'] == tMap[s.charAt(endPointer) - 'A'] && tMap[s.charAt(endPointer) - 'A'] != 0)
                letters++;
//            endPointer++;
            while(letters == st.size() && startPointer <= endPointer){
                char start = s.charAt(startPointer);
                sMap[s.charAt(startPointer) - 'A']--;
                if (endPointer - startPointer + 1 < smallest) {
                    smallest = endPointer - startPointer + 1;
                    ans = s.substring(startPointer,endPointer+1);
                }
                if(tMap[s.charAt(startPointer) - 'A'] != 0 && (sMap[s.charAt(startPointer) - 'A'] < tMap[s.charAt(startPointer) - 'A'] )){
                    letters--;
                }
                startPointer++;
            }
            endPointer++;
        }

        return ans;
    }

    public static boolean isSubString(int[] s1, int[] s2, String t){
       for(int i=0;i< t.length();i++){
           if(s2[t.charAt(i) - 'A'] > s1[t.charAt(i) - 'A'])
               return false;
       }
       return true;
    }
}
