public class MaxConsecutiveOnes{
    public static int bruteForce(int[] arr , int k){
        int maxLen = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int zeros = 0;
            for(int j = i ; j < arr.length ; j++){
                if(arr[i] == 0){
                    zeros++;
                }
                if(zeros > k) break;
                maxLen = Math.max(maxLen , j - i + 1);
            }
        }
        return maxLen;
    }
    public static int betterSol(int[] arr , int k ){
        int left = 0 , right = 0 , n = arr.length , len = 0 ;
        int zero = 0;
        while(right < n){
            if(arr[right] == 0) zero++;
            while(zero > k){
                if(arr[left] == 0) zero--;
                left++;
            } 
            len = Math.max(len , right - left + 1);
            right++;
        }
        return len;
    }

    public static int optimal(int[] nums, int k) {

        // Left pointer of the sliding window
        int left = 0;

        // Counter for zeros in the window
        int zerocount = 0;

        // Variable to store maximum window length
        int maxlen = 0;

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // If current element is zero, increment zerocount
            if (nums[right] == 0) {
                zerocount++;
            }

            // If zerocount exceeds k, move left and adjust zerocount
            if (zerocount > k) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                // Shrink window from left
                left++; 
            }

            // Update maximum window size
            maxlen = Math.max(maxlen, right - left + 1);
        }

        // Return the final result
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 3;

        // Output the result
        System.out.println(betterSol(nums, k));
    }
}