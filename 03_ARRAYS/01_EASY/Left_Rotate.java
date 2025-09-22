// Problem Statement: Given an array of N integers, left rotate the array by one place.
public class Left_Rotate {
    public int[] left_rotate(int[] arr){
        int[] temp = new int[arr.length];
        for(int i = 1; i<arr.length - 1;i++){
            temp[i - 1] = arr[i];
        }
        temp[arr.length - 1] = arr[0];
        return temp;
    }
    // now lets decrease the space complexity 
    public int[] solve(int[] arr){
        int temp = arr[0] ;
        for(int i = 1 ; i<arr.length ; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Left_Rotate shift = new Left_Rotate();
        int[] solve = shift.solve(arr);
        for(int i : solve){
            System.out.print(i + " ");
        }
    }
}
