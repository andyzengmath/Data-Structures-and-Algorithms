public class Solution {
    /**
     * @param n: an integer
     * @return: if n is a power of three
     */
    public boolean isPowerOfThree(int n) {
        // Write your code here
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}