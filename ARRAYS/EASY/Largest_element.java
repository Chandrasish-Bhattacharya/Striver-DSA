// Find the Largest element in an array
// how can I solve this problem 

public class Largest_element{
    public static int BruteForce(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++){
            largest = Math.max(largest,arr[i]);
        }
        return largest;
    }
    public static void main(String[] args){
        int arr[] = {1,9,10,0,5};
        System.out.println(BruteForce(arr));
    }
}