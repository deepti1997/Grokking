package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*Given a string s, find the length of the longest substring without repeating characters.*/
public class LongestSubstingWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("deepti"));
    }
    static int lengthOfLongestSubstring(String s){
        List<Character> frequency = new ArrayList<>();
        int winStart=0,winEnd=0,maxLength=0;
        while(winEnd < s.length()){
            char rightChar = s.charAt(winEnd);
            if(frequency.contains(rightChar)){
                frequency.remove(new Character(s.charAt(winStart)));
                winStart++;
            }
            else{
                frequency.add(rightChar);
                winEnd++;
                maxLength = Math.max(maxLength,frequency.size());
            }
        }
        return maxLength;
    }
}
