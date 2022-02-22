package SlidingWindow;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
/*Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.*/

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithDistinctChars {
    public static void main(String[] args) {
        MaxSubArrayWithDistinctChars maxSubArrayWithDistinctChars = new MaxSubArrayWithDistinctChars();
        System.out.println(maxSubArrayWithDistinctChars.maxKDistinctCharArray("araaci",2));
        System.out.println(maxSubArrayWithDistinctChars.maxKDistinctCharArray("araaci",1));
        System.out.println(maxSubArrayWithDistinctChars.maxKDistinctCharArray("cbbebi",3));
    }
    int maxKDistinctCharArray(String s, int k){
        //start with the window at the beginning
        //we are going to have to keep a track on how many types of chars are we inserting... use hashmap, or hashset - its sixe will indicate the distinct characters
        //if, after addition of an element to the hashmap, makes the size greater than k, the remove start element and update the required length
        //keep adding with every iteration where windowEnd is increased by 1
        Map<Character,Integer> frequency = new HashMap<>();
        int winStart=0,winEnd=0, maxLength = 0;
        for(winEnd =0;winEnd<s.length();winEnd++){
            char rightCh = s.charAt(winEnd);
            frequency.put(rightCh,frequency.getOrDefault(rightCh,0)+1);
            //we decrease the window size till we get rid of a particular char
            while(frequency.size() > k){
                char leftCh = s.charAt(winStart);
                frequency.put(leftCh,frequency.get(leftCh)-1);
                if(frequency.get(leftCh) == 0){
                    frequency.remove(leftCh);
                }
                winStart++;
            }
            maxLength = Math.max(maxLength,winEnd-winStart+1);
        }
        return maxLength;
    }
}
