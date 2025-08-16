
import java.util.Scanner;

// ***
// **
// *
public class PATTERN5{
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int row = Sc.nextInt();
        int col = Sc.nextInt();
        for(int i = 0 ; i<row ; i++){
            for(int j = col ; j>i ; j--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}