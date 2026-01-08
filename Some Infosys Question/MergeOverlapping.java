// // Problem Statement: Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
// Input : intervals=[[1,3],[2,6],[8,10],[15,18]]
// Output : [[1,6],[8,10],[15,18]]
// Explanation : Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6] intervals.

// Input : [[1,4],[4,5]]
// Output :  [[1,5]]
// Explanation :  Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].

import java.util.*;
class Solution{
    public List<List<Integer>> merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0 ; i < n ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while(j < n && intervals[j][0] < end){
                    end = Math.max(end , intervals[j][1]);
                    j++;
            }
            ans.add(Arrays.asList(start , end));
            i = j - 1;
        }
        return ans;
    }

    public int[][] merge(int[][] intervals) { // lead code sol 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[][] arrlist = new int[n][2];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r == 0 || intervals[i][0] > arrlist[r - 1][1]) {
                arrlist[r][0] = intervals[i][0];
                arrlist[r][1] = intervals[i][1];
                r++;
            } else {
                arrlist[r - 1][1] = Math.max(arrlist[r - 1][1], intervals[i][1]);
            }

        }
        return Arrays.copyOf(arrlist, r);
    }
}
public class MergeOverlapping {
     public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> result = sol.merge(intervals);
        for (List<Integer> interval : result) {
            System.out.print(interval + " ");
        }
    }
}
