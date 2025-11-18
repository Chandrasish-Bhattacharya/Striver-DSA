// Problem Statement
// Given an integer n, a 0-indexed integer array nums of length n+1 is generated with the following rules:
// 1. nums[0] = 0;	
// 2. nums[1] = 1;
// 3. 2<= 2*i <=n : nums[2*i] = nums[i];
// 4. 2<= 2*i + 1 <=n : nums[2*i + 1] = nums[i] + nums[i + 1];
// Return the maximum integer in the array nums .

import java.util.Scanner;

public class ArraysI {
    public static int solution(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 1; 2 * i <= n; i++) {
            arr[2 * i] = arr[i];
            max = Math.max(max, arr[2 * i]);

            if (2 * i + 1 <= n) {
                arr[2 * i + 1] = arr[i] + arr[i + 1];
                max = Math.max(max, arr[2 * i + 1]);
            }
        }
        return max;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(solution(n));    
    }
}
