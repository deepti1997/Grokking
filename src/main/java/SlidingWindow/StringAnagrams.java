package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given a string and a pattern, find all anagrams of the pattern in the given string.*/
public class StringAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab","abc"));
    }
    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length())
            return list;
        int[] sMap = new int[26];
        int[] pMap = new int[26];

        for (int i=0;i<p.length();i++){
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }
        int k = p.length();

        for(int i=0;i<s.length()-k;i++){
            if(matches(sMap,pMap))
                list.add(i);
            sMap[s.charAt(i) - 'a']--;
            sMap[s.charAt(i + k) - 'a']++;
        }
        if(matches(sMap,pMap))
            list.add(s.length()-k);
        return list;
    }

    public static boolean matches(int[]sMap, int[]pMap){
        for(int i=0;i<26;i++){
            if(sMap[i] != pMap[i])
                return false;
        }
        return true;
    }
}
