public class LintCode_928 {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
    
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        int ans = 0, l = 0, r = 0, len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            if (map.size() <= 2) {
                char c = s.charAt(r);
                map.put(c, r);
                r++;
            }
            if (map.size() > 2) {
                int left = len;
                for (int i: map.values()) {
                    left = Math.min(left, i);
                }
                char c = s.charAt(left);
                map.remove(c);
                l = left + 1;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}