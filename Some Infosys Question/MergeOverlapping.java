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
        int 
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
