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
    public static void markrow(int i, int[][] arr) {
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void markcol(int j, int[][] arr){
        for(int i = 0; i<arr.length; i++){
            if(arr[i][j]!= 0){
                arr[i][j] = -1;
            }
        }
    }

    public static void matrix(int[][] matrix) { // Brute Force
    for(int i = 0 ; i< matrix.length ; i++){
        for(int j = 0; j< matrix[0].length ; j++){
            if(matrix[i][j] == 0){
                markrow(i, matrix);
                markcol(j, matrix);
                }
            }
        }
    for(int i = 0 ; i<matrix.length ; i++){
        for(int j = 0;j<matrix[0].length ; j++){
            if(matrix[i][j] == -1){
                matrix[i][j] = 0;
                }
            }
        }
    }

    // Better Sol
    public static void matrixBetter(int[][] matrix){
        int[] row = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(row[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println("Inital Matrix");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("New Matrix");
        matrixBetter(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
