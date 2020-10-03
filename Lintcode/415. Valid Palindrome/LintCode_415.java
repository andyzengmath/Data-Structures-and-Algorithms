public class Solution {
    /** Leet 125
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     * O(n) time without extra memory.
     */

    public boolean isPalindrome(String s) {
        // write your code here
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right; 
            }
        }
        return true;
    }
}