// Length of Longest Substring without any Repeating Character
// Problem Statement: Given a String, find the length of longest substring without any repeating character.

// Examples:

// Example 1:

// Input: s = ”abcabcbb”

// Output: 3

// Explanation: The answer is abc with length of 3.

// Example 2:

// Input: s = ”bbbbb”

// Output: 1

// Explanation: The answer is b with length of 1 units.

// Example 3 :
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashSet;

class Solution{
    public int bruteForce(String s){
        int count = Integer.MIN_VALUE;
        if(s.length() == 0 || s.length() == 1) return s.length();
        int n = s.length();
        for(int i = 0 ; i<n ; i++){
            HashSet<Character> set = new HashSet();
            for(int j = i ; j<n ;j++){
                if(set.contains(s.charAt(j))){
                    count = Math.max(count, j - i);
                    break;
                }
                set.add(s.charAt(j));
            }
        }
        return count;
    }

    public int optimal(String s){
        if(s.length() == 0) return 0;
        int Maxcount = 0;
        int left = 0;
        HashSet<Character> set = new HashSet();
        for(int right = 0 ; right < s.length() ; right++){
            if(set.contains(s.charAt(right))){
                while(left < right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            Maxcount = Math.max(Maxcount , right - left + 1);
        }
        return Maxcount;
    }
}

public class WithoutRepeatingCharacter {
    
}
