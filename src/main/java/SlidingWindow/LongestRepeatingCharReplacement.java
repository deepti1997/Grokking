package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/longest-repeating-character-replacement/
/*You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.*/
public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> frequency = new HashMap<>();
        int winStart=0,winEnd=0,maxLength=0;
        int maxFrequency = 0 ;
        while(winEnd < s.length()){
            char rightCh = s.charAt(winEnd);
            frequency.put(rightCh,frequency.getOrDefault(rightCh,0)+1);
            maxFrequency = Math.max(maxFrequency,frequency.get(rightCh));
            if(winEnd - winStart + 1 - maxFrequency > k){
                char leftChar = s.charAt(winStart);
                frequency.put(s.charAt(winStart),frequency.get(leftChar) -1 );
                if(frequency.get(leftChar) == 0)
                    frequency.remove(leftChar);

                winStart++;
            }
            maxLength = Math.max(maxLength,winEnd - winStart +1);
            winEnd++;

        }return maxLength;
    }
}
