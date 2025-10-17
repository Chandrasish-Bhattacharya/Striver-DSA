// Problem Statement: Given a string s, reverse the words of the string.

// Examples:

// Example 1:
// Input: s=”this is an amazing program”
// Output: “program amazing an is this”

// Example 2:
// Input: s=”This is decent”
// Output: “decent is This”

public class Reverse_Words_in_a_String {
    public static String mysol(String str) {  // 
        String[] ans = str.split(" ");
        StringBuilder build = new StringBuilder();
        for(int i = ans.length - 1 ; i>=0 ; i--){
            build.append(ans[i] + " ");
        }
        return build.toString();
    }

    public static String reverse(String str) {
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }

    public static String reverse(String str, int start, int end) {
        String ans = "";
        for (int i = end; i >= start; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }

    public static String bettersol(String str) {
        str = reverse(str);  // Step 1: reverse whole string
        String word = "";
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            word = "";
            while (i < str.length() && str.charAt(i) != ' ') {
                word += str.charAt(i);
                i++;
            }
            // reverse the current word
            word = reverse(word, 0, word.length() - 1);
            if (word.length() > 0) {
                ans += " " + word;
            }
        }

        return ans.trim();
    }

    public static void main(String[] args) {
        String str = "This is a String";
        System.out.println(bettersol(str));
    }
}
