// Situation: A product team records user action logs (characters representing actions). They want the longest continuous sequence of actions without repetition to study engagement.

// Problem: Given string **S** representing user actions, find the length of the longest substring **without repeating characters**.
// Sample
// Input:
// abcabcbb
// Output:
// 3

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    // my sol
    public int mysol(String str) {
        HashMap<Character , Integer > mpp = new HashMap<>(); // char for char and integer for the last occurence 
        int left = 0 , right = 0;
        int n = str.length();
        int len = 0;
        while(right<n){
            if(mpp.containsKey(str.charAt(right)))
                left = Math.max(left, mpp.get(str.charAt(right)) + 1); // bassically comparing the last occurence of left and making sure it continue after we visited that element last time 
            mpp.put(str.charAt(right), right); // if the element is not present add the element 
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}

public class UserSession {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Solution s = new Solution();
        System.out.println(s.mysol(str));
    }
}
