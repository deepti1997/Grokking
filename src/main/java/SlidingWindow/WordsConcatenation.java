package SlidingWindow;

/*https://leetcode.com/problems/substring-with-concatenation-of-all-words/
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.
Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
"wordgoodgoodgoodbestword"
["word","good","best","good"]

"lingmindraboofooowingdingbarrwingmonkeypoundcake"
["fooo","barr","wing","ding","wing"]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenation {
    public static void main(String[] args) {
        System.out.println(findSubstring("lingm", new String[]{"li","ng"}));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> frequencyMap = new HashMap<>();
        Map<String,Integer> frequencyMapInS = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            frequencyMap.put(words[i], frequencyMap.getOrDefault(words[i],0)+1 );
        }
        int k = words[0].length();
        for(int i=0;i< words.length*k;i = i+k)
            frequencyMapInS.put(s.substring(i,i+k),frequencyMapInS.getOrDefault(s.substring(i,i+k),0)+1 );
        for(int i =0;i<s.length()-words.length*k;i = i+k){
            if(checkString(frequencyMap,frequencyMapInS))
                result.add(i);
            String startString = s.substring(i,i+k);
            String endString = s.substring(i+ words.length*k,i+ words.length*k+k);
            frequencyMapInS.put(startString,frequencyMapInS.get(startString)-1);
            frequencyMapInS.put(endString,frequencyMapInS.getOrDefault(endString,0)+1);
        }
        if(checkString(frequencyMap,frequencyMapInS))
            result.add(s.length()-words.length*k);
        return result;
    }
    public static boolean checkString(Map<String,Integer> frequencyMap, Map<String,Integer> frequencyMapInS){
        for(Map.Entry<String,Integer> entry : frequencyMap.entrySet()) {
            if(frequencyMap.get(entry.getKey()) != frequencyMapInS.get(entry.getKey()))
                return false;
        }
        return true;
    }
}
