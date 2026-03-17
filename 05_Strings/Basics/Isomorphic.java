import java.util.HashMap;
import java.util.Scanner;

public class Isomorphic{
    public static boolean sol(String s, String t){
        if(s.length() != t.length() ){
            return false;
        }
        HashMap<Character , Character> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                return false;
            }
        }
            map.put(s.charAt(i), t.charAt(i));
        }
        
        return true;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String t = sc.next();

    System.out.println(sol(s, t));
    sc.close();
    }
}