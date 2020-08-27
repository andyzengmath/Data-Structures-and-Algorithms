public class LintCode_397 {
    /**
     * @param A: An array of Integer
     * @return: an integer
     * O(n) time and O(1) extra space.
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int result = 1;

        // from left to right
        int length = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            result = Math.max(result, length);
        }
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
            } else {
                length = 1;
            }
            result = Math.max(result, length);
        }

        return result;

    }
}