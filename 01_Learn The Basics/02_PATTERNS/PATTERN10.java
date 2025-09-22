// *
// **
// ***
// ****
// *****
// ****
// ***
// **
// *

public class PATTERN10 {
    public static void PATTERN10(int n) {
        for (int i = 0; i < 2 * n ; i++) {
            if (i <= n) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
            } else{

            
                for (int k = 0; k<2*n - i; k++) {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        PATTERN10(n);
    }
}