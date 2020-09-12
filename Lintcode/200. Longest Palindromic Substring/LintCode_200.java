public class LintCode_200 {
    /** Leetcode-5
     * O(n^2)
     * @param s: input string
     * @return: a string as the longest palindromic substring
     * O(n2) time is acceptable. Can you do it in O(n) time.
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int longest = 1, start = 0;
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]) {
                start = i;
                longest = 2;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j); 
                if (isPalindrome[i][j] && j - i + 1 > longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        return s.substring(start, start + longest);

    }
}