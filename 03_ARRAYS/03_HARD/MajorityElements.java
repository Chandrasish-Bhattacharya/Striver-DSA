// Find the elements that appears more than N/3 times in the array
// Problem Statement: Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.
// Example 1:
// Input:
//  nums = [1, 2, 1, 1, 3, 2]  
// Output:
//  [1]  
// Explanation:
//  Here, n / 3 = 6 / 3 = 2.  
// Therefore, the elements appearing 3 or more times are: [1].

// Example 2:
// Input:
//  nums = [1, 2, 1, 1, 3, 2, 2]  
// Output:
//  [1, 2]  
// Explanation:
//  Here, n / 3 = 7 / 3 = 2.  
// Therefore, the elements appearing 3 or more times are: [1, 2].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElements {
    public List<Integer> majorityElementbruteForce(int[] nums){ // complete bruteForce 
        Set<Integer> ansSet = new HashSet<>();
        for(int i = 0 ; i< nums.length ; i++){
            int count = 0;
            for(int j = 0 ; j<nums.length ; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count >= (nums.length / 3 + 1)){
                ansSet.add(nums[i]);
            }
        }
        List<Integer> ans = new ArrayList<>(ansSet);
        return ans;
    }

    public List<Integer> majorityElementbettersol(int[] nums) { // Fails for [2,2]
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) >= (nums.length / 3 + 1)) {
                ans.add(nums[i]);
            }
            if (ans.size() == 2)
                break;
        }
        return ans;
    }

    public List<Integer> majorityElementOptimalSol(int[] nums){
        int cnt1 = 0 , cnt2 = 0;
        int ele1 = Integer.MIN_VALUE , ele2 = Integer.MIN_VALUE;
        for(int i = 0 ; i<nums.length ; i++){
            if(cnt1 == 0 && ele2 != nums[i]){
                cnt1 = cnt1 + 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && ele1 != nums[i]){
                cnt2 = cnt2 + 1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]){
                cnt1++;
            }
            else if(ele2 == nums[i]){
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        // mow lets check 
        cnt1 = 0 ; cnt2 = 0;
        for(int i = 0; i<nums.length ;i++){
            if(ele1 == nums[i]) cnt1++;
            if(ele2 == nums[i]) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        int maj = (nums.length / 3) + 1;
        if(cnt1 >= maj) ans.add(ele1);
        if(cnt2 >= maj) ans.add(ele2);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 2 };

        MajorityElements sol = new MajorityElements();
        List<Integer> ans = sol.majorityElementOptimalSol(arr);

        System.out.print("The majority elements are: ");
        for (Integer it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}
