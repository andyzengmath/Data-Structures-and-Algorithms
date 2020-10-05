public class LintCode_384 {
    /** LeetCode 3
     *  1review 10-05-20
     * @param s: a string
     * @return: an integer
     * Challenge: time complexity O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> window = new HashSet<>();
        int left = 0, curLen = 0, maxLen = 0;
        char[] sc = s.toCharArray();
        for (char ch: sc) {
            while (window.contains(ch)) {
                window.remove(sc[left]);
                left++;
                curLen--;
            }
            window.add(ch);
            curLen++;
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;



    }
}