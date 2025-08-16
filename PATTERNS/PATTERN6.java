
import java.util.Scanner;
// 123
// 12
// 1
public class PATTERN6{
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int row = Sc.nextInt();
        
        for(int i = 0 ; i<row ; i++){
            for(int j = row ; j>i ; j--){
                System.out.print(row - j + 1);
            }
            System.out.println();
        }
    }
}