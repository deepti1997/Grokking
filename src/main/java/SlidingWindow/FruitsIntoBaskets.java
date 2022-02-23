package SlidingWindow;
//https://leetcode.com/problems/fruit-into-baskets/
/*You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.*/

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit1(new int[]{1,2,3,2,2}));
    }
    static int totalFruit(int[] fruits){
        //using dynamic sizing of window
        Map<Integer,Integer> frequency = new HashMap<>();
        int winStart = 0, maxLength = 0;
        for(int winEnd = 0; winEnd<fruits.length;winEnd++){
            frequency.put(fruits[winEnd], frequency.getOrDefault(fruits[winEnd],0)+1);
            while(frequency.size() > 2){
                frequency.put(fruits[winStart],frequency.get(fruits[winStart])-1);
                if(frequency.get(fruits[winStart]) == 0)
                    frequency.remove(fruits[winStart]);
                winStart++;
            }
            maxLength = Math.max(maxLength,winEnd-winStart+1);
        }
        return maxLength;
    }

    //a faster implementation
    static int totalFruit1(int[] fruits){
        Map<Integer,Integer> frequency = new HashMap<>();
        int winStart = 0,winEnd =0, maxLength = 0;
        while(winEnd < fruits.length){
            if(frequency.size() > 2){
                maxLength = Math.max(maxLength,winEnd-winStart-1);
                frequency.put(fruits[winStart],frequency.get(fruits[winStart])-1);
                if(frequency.get(fruits[winStart]) == 0)
                    frequency.remove(fruits[winStart]);
                winStart++;
            }
            else{
                frequency.put(fruits[winEnd], frequency.getOrDefault(fruits[winEnd],0)+1);
                winEnd++;
            }
        }
        maxLength = frequency.size()>2?Math.max(maxLength,winEnd-winStart-1): Math.max(maxLength,winEnd-winStart);
        return maxLength;
    }
}
