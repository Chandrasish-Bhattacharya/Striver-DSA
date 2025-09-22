// Find the highest/lowest frequency element
// Problem Statement: Given an array of size N. Find the highest and lowest frequency element.
// Examples:

// Example 1:
// Input: array[] = {10,5,10,15,10,5};
// Output: 10 15
// Explanation: The frequency of 10 is 3, i.e. the highest and the frequency of 15 is 1 i.e. the lowest.

// Example 2:

// Input: array[] = {2,2,3,4,4,2};
// Output: 2 3
// Explanation: The frequency of 2 is 3, i.e. the highest and the frequency of 3 is 1 i.e. the lowest.
public class Max_And_Min_Frequence {
    public int[] Max_Min_Freq(int[] arr) {
        int[] hash = new int[100]; // Increased size to avoid IndexOutOfBounds for larger values
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++; // Count frequencies
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int maxEle = -1;
        int minEle = -1;

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                if (hash[i] > maxFreq) {
                    maxFreq = hash[i];
                    maxEle = i;
                }
                if (hash[i] < minFreq) {
                    minFreq = hash[i];
                    minEle = i;
                }
            }
        }

        return new int[]{maxEle, minEle};
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 10, 15, 10, 5};
        Max_And_Min_Frequence obj = new Max_And_Min_Frequence();
        int[] sol = obj.Max_Min_Freq(array);
        System.out.println("Highest frequency element: " + sol[0]);
        System.out.println("Lowest frequency element: " + sol[1]);
    }
}
