
import java.util.ArrayList;
import java.util.List;

// Merge Sort Algorithm

// Problem Statement: Given an array of size n, sort the array using Merge Sort.
// Input : N=7,arr[]={3,2,8,5,1,4,23}
// Output : {1,2,3,4,5,8,23}
// Explanation : Given array is sorted in non-decreasing order.
// Input : N=5, arr[]={4,2,1,6,7}
// Output : {1,2,4,6,7}
// Explanation : Given array is sorted in non-decreasing order.
public class mergeSort{

    public static void merge(int[] arr , int low , int mid , int high){
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        
        while(left <= mid && right <= high){
            
            if(arr[left] <= arr[right])
                temp.add(arr[left++]);
            
            else
                temp.add(arr[right++]);
        }
        
        while(left<=mid)
            temp.add(arr[left++]);
        
        while(right<=high)
            temp.add(arr[right++]);
        
        // coping to the og array
        for(int i = low ; i <=high ; i++){
            arr[i] = temp.get(i - low);
        }
    }
    public static void mergeSort(int[] arr, int low ,int high){
        if(low>=high){
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public static void main(String[] args){
        int[] arr = {4,2,1,6,7};
        mergeSort(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}