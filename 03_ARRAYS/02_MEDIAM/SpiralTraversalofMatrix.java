// Given an m x n matrix, return all elements of the matrix in spiral order.
// Problem Statement: Given a Matrix, print the given matrix in spiral order.

// Example 1:
// Input: Matrix[][] = { { 1, 2, 3, 4 },
//                       { 5, 6, 7, 8 },
//                      { 9, 10, 11, 12 },
//                      { 13, 14, 15, 16 } }

// Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
// Explanation: The output of matrix in spiral form.

// Example 2:
// Input: Matrix[][] = { { 1, 2, 3 },
//                       { 4, 5, 6 },
//                       { 7, 8, 9 } }
                
// Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
// Explanation: The output of matrix in spiral form.

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalofMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0 , left = 0 , bottom = matrix.length - 1 , right = matrix[0].length - 1;
        while(top <= bottom && left<=right){
            for(int i = left ; i<= right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top ; i<= bottom ; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(matrix[bottom][i]);

                bottom--;
        }
        if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);

                left++;
            }
        }
        return ans;
    }
     public static void main(String[] args) {
        
        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};
        SpiralTraversalofMatrix sol = new SpiralTraversalofMatrix();
        List<Integer> ans = sol.spiralOrder(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}
