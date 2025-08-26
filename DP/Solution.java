public class Solution {
    public void moveZeroes(int[] nums) {
        int[] Nonzero = new int[nums.length];
        int count = 0, j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                Nonzero[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            Nonzero[i] = 0;
        }

        // Copy back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Nonzero[i];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Before:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sol.moveZeroes(nums);

        System.out.println("\nAfter:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
