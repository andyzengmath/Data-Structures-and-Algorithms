import java.util.Hashmap;
import java.util.*;

public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        int oddCount = 0;
        int len = s.length();

        for (int i = 0; i < len; i ++){
            char c  = s.charAt(i);
            if (freq.containsKey(c)) {
                int oldValue = freq.get(c);
                freq.replace(c, oldValue + 1);
            } else {
                freq.put(c, 1);
            }
        }

        Iterator freqIter = freq.entrySet().iterator();

        while (freqIter.hasNext()) {
            Map.Entry element = (Map.Entry)freqIter.next();
            int count = (int) element.getValue();
            if (count % 2 == 1) {
                oddCount += 1;
            } 
        }

        if (oddCount >= 2) {
            return len - (oddCount - 1);
        } else {
            return len;
        }
        
    }

    public void test(){
        
        System.out.println(longestPalindrome("1233322221"));
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        sol.test();
    }
}