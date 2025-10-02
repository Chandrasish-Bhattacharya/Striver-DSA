

public class ValidParentesis {
    static boolean isValid(String str){
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                count++;
            }
            else if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']'){
                count--;
            }
        }
        if (count == 0) return true;
        else return false;
    }
    public static void main(String[] args){
        String str = "(*)";
        System.out.println(isValid(str));
    }
}
