
import java.util.*;

class Solution {

    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
         for(int i=0;i<=arr.length-k;i++){
            // ArrayList<Integer> temp = new ArrayList<>();
            HashSet<Integer> temp = new HashSet<>();
            for(int j=i;j<i+k;j++){
                if(!temp.contains(arr[j]))
                temp.add(arr[j]);
            }
            result.add(temp.size());
        }
        return result;
    }
}

public class Countdistinctelements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        Solution sol = new Solution();
        ArrayList<Integer> ans = sol.countDistinct(arr, k);
        System.out.println(ans); // Output: [3, 4, 4, 3] }
    }
}
