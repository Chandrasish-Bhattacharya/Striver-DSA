import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PascalTriangle {
    // public List<List<Integer>> generate(int numRows) {
        
    // }
    // Lets First Learn nCr
    public int nCr(int n , int c){
        
        int res = 1;
        for(int i = 0 ; i< c - 1 ; i++){
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // Now lets implement Pascal Triangle 
    public List<List<Integer>> Pascal(int n){ // kind of a brute force
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0 ; i<n ; i++){
            List<Integer> temp = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for(int j = 1 ; j<i ;j++){
                temp.set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args){
        PascalTriangle sol = new PascalTriangle();
        int n = 5;
         // Generate and print Pascal's Triangle
        List<List<Integer>> result = sol.Pascal(n);
        for (List<Integer> row : result) {
            for (Integer val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}