// Problem statement: You are given a sorted array of integers and a target, your task is to search for the target in the given array. Assume the given array does not contain any duplicate numbers.

// Let’s say the given array is = {3, 4, 6, 7, 9, 12, 16, 17} and target = 6.
public class Binary_Search {
    public static int itearative(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }

    public static int recursive(int[] arr ,int target,int low ,int high){
        if(low>high) return -1;
        int mid = (high + low) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid]<target) return recursive(arr, target, mid + 1, high);
        else return recursive(arr, target, low, mid - 1);
    }
    

    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 6;
        System.out.println(recursive(arr, target , 0 , arr.length));
    }
}
