public class LintCode_807 {
    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        // Write your code here
        String binary = "";
        while (n > 0) {
            binary = n % 2 + binary;
            n = n / 2;
        }
        int i = 0, j = binary.length() - 1;
        while (i < j) {
            if (binary.charAt(i) != binary.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}