// Set Matrix Zero
// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
// Examples 1:

// Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 
// Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

// Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

// Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
public class SetMatrixZero {
    public static void matrix(int [][] matrix){
        int Row_value = -1 ,Col_value = -1;
        for(int i = 0 ; i<matrix.length ;i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(matrix[i][j]== 0){
                    Row_value = i+1;
                    Col_value = j+1;
                }
            }
        }
        for(int i = 0 ; i<matrix.length ;i++){
            matrix[i][0] = 0;
        }
        for(int j = 0 ; j<matrix.length ;j++){
            matrix[0][j] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        matrix(arr);
        for(int i = 0 ; i<arr.length ;i++){
            for(int j = 0 ; j<arr[0].length ; j++){
            System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
