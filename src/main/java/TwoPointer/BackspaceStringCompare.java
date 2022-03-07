package TwoPointer;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/
/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".*/
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("acd#b","ace#b"));
    }
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    public static String build(String s){
        Stack<Character> ans = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '#')
                ans.push(s.charAt(i));
            else if(!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
    public static boolean backspaceCompare1(String s, String t) {
        int skipS=0;
        int skipT=0;
        int i = s.length()-1;
        int j = t.length()-1;
        while(i >= 0 || j>=0){
            while(i>=0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }
                else if(skipS > 0){
                    skipS--;
                    i--;
                }
                else break;
            }
            while(j>=0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }
                else if(skipT > 0){
                    skipT--;
                    j--;
                }
                else break;
            }
            if(i>=0 && j>=0 && s.charAt(i) != t.charAt(j))
                return false;
            if((i >= 0 ) != ( j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
