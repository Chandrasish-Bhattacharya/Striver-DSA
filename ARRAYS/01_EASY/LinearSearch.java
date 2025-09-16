// Problem Statement: Given an array, and an element num the task is to find if num is present in the given array or not. If present print the index of the element or print -1.



public class LinearSearch {
    public int Search(int[] arr,int target){
        for(int i = 0;i<arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,9,10,2,0};
        int target = 10;
        LinearSearch search = new LinearSearch();
        System.out.println(search.Search(arr, target));
    }
}

