// Find GCD of two numbers
public class GCD_HCF {
    public static int gcd(int a,int b){
        int maxfactor = 1;
        for(int i = 2 ; i <= Math.min(a,b); i++){
            if(a % i == 0 && b % i == 0){
                maxfactor = i;
            }
        }
        return maxfactor;
    }

    
    // Better approach 
    public static int gcd_Better(int a , int b){
        for(int i = Math.min(a,b) ; i >= 1 ; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }


    // Best Solution
    public static int gcd_Best(int a,int b){
        while(a>0 && b>0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a == 0) return b;
        return a;
    }

    public static void main(String[] args){
        int a = 9;
        int b = 15;
        System.out.print(gcd_Best(a,b));
    }
}
