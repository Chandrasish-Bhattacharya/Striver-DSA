 public class LongestRepeatingCharacterReplacement{
    public int bruteForce(String s , int k){
        
        int maxlen = 0;
        for(int i = 0 ; i<s.length() ; i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            for(int j = 0 ; j < s.length() ; j++){
                freq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);

                int windowSize = j - i + 1;
                int replaceMent = windowSize - maxFreq;

                if(replaceMent <= k){
                    maxlen = Math.max(maxFreq, windowSize);
                }
            } 
        }
        return maxlen;
    }
    public static void main(String[] args){
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "BAABAABBBAAA";
        int k = 2;
        System.out.println(sol.bruteForce(s, k));
    }
 }