public class LintCode_1261 {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: return an integer
     */
    public int longestSubstring(String s, int k) {
        // write your code here
        int len = s.length();
        if (len == 0 || k > len) {
            return 0;
        }
        if (k < 2) return len;
        return count(s.toCharArray(), k, 0, len - 1);
    }
    
    private static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 - k < 0) return 0;
        int[] times = new int[26];
        
        for (int i = p1; i <= p2; i++) {
            times[chars[i] - 'a']++;
        }
        
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {
            p1++;
        }
        
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            p2--;
        }
        
        if (p2 - p1 + 1 < k) return 0;
        for (int i = p1; i <= p2; i++) {
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1) , count(chars, k , i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
}