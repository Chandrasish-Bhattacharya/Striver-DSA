import java.util.Scanner;

public class FrogJumpKsteps {
    public int TotalCostUsingRecursion(int[] height,int idx,int k){
        if(idx == 0){
            return 0;
        }
        int minStep = Integer.MAX_VALUE;
        for(int i = 1 ; i <= k ; i++){
            if(idx - i > 0){
                int jump = TotalCostUsingRecursion(height, idx - i, k) + Math.abs(height[idx] - height[idx - i]);
                minStep = Math.min(minStep,jump);
            }
        }
        return minStep;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim().replaceAll("[//[//]{}()<>]", " ");
        
        
    }
}
