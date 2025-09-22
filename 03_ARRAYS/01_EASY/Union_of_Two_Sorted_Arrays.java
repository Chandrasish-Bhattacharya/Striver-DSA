import java.util.ArrayList;
import java.util.HashSet;

public class Union_of_Two_Sorted_Arrays {
    // there are many ways to do this but I can try doing it using Set 
    // which is kind of better than the brute force 
    public static ArrayList<Integer> union1(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int i : arr2){
            set.add(i);
        }
        for(int i : set ){
            result.add(i);
        }
        return result;
    }
    public static void main(String args[]) {
        int n = 10, m = 7;
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // m size 
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 }; // n size 
        ArrayList<Integer> Union = union1(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Union)
            System.out.print(val + " ");
    }
}
