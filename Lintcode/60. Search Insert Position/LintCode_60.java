public class LintCode_60 {
    /**LeetCode-35
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        // binary search
        if (A == null || A.length == 0 || target <= A[0]) {
            return 0;
        } else if (target >= A[A.length - 1]) {
            return A[A.length - 1];
        }
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}