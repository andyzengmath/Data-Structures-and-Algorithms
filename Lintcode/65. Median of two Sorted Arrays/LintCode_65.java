public class LintCode_75 {
    /* LeetCode_4 hard
    1review 10-04-20
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     * Challenge: The overall run time complexity should be O(log (m+n)).
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // O(m+n) version
        int m = A.length, n = B.length;
        int p1 = 0, p2 = 0;
        int left = -1, right = -1;
        for (int i = 0; i < (m + n) / 2 + 1; i++) {
            left = right;
            if (p1 >= A.length || p2 < B.length && A[p1] > B[p2]) {
                right = B[p2++];
            } else {
                right = A[p1++];
            }
        }
        return (m + n) % 2 == 1? right: (left + right) / 2.0;

    }
}