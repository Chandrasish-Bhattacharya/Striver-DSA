import java.util.Scanner;

public class RepresentationInMatrix{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // for nodes 
        int m = sc.nextInt(); // for edges

        int[][] adj_Matrix = new int[n+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j<=n ; j++){
                System.out.print("[" + i + "]" + "[" + j + "]");
                adj_Matrix[i][j] = sc.nextInt();
            }
        System.out.println("");
        }
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j<=n ; j++){
                System.out.print(adj_Matrix[i][j]);
            }
        System.out.println("");
        }
        sc.close();
    }
}