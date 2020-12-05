public class LintCode_386 {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }

        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max_len = 1;
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == k + 1) {
                int idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                left = idx + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;

    }
}