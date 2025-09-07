// *********
//  *******
//   *****
//    ***
//     *



public class PATTERN8 {
    public static void PATTERN8(int n){
        for(int i = 0 ; i<n ;i++){
            for(int j = 0 ; j<i ; j++){
                System.out.print(" ");
            }
            for(int k = 0 ; k< 2*(n) - (2*i + 1) ; k++){
                System.out.print("*");
            }
            for(int l = 0 ; l<i ; l++){
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int n = 5;
        PATTERN8(n);
        // pattern 9 = PATTERN7(n) + PATTERN8(n);
    }
}
