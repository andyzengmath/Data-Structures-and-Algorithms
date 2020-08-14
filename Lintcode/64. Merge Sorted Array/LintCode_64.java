public class LintCode_64 {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int a = m - 1, b = n - 1, i = m + n - 1;

        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[i--] = A[a--];
            } else {
                A[i--] = B[b--];
            }
        }

        while (a >= 0) {
            A[i--] = A[a--];
        }
        while (b >= 0) {
            A[i--] = B[b--];

    }
}