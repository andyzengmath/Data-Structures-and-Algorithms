public class LintCode_6 {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     * LeetCode 21
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] c = new int[A.length + B.length];
        int index1 = 0;
        int index2 = 0;
        int currIndex = 0;

        while (index1 < A.length && index2 < B.length) {
            if (A[index1] < B[index2]) {
                c[currIndex] = A[index1];
                index1 += 1;
                currIndex += 1;
            } else {
                c[currIndex] = B[index2];
                index2 += 1;
                currIndex += 1;
            }

        }

        while (index1 < A.length) {
            c[currIndex] = A[index1];
            currIndex += 1;
            index1 += 1;
        }

        while (index2 < B.length) {
            c[currIndex] = B[index2];
            currIndex += 1;
            index2 += 1;
        }

        return c;
    }
}