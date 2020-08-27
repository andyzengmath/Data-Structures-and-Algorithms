public class doublePointer {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;
        int low = 0, high = 1, state = A[high] - A[low], max = 0; l = 0;
        while (high < A.length) {
            if ((A[high] - A[high - 1]) * state > 0) {
                l++;
                max = (max > l) ? max : l;
                high++;
            } else {
                l = 0;
                low++;
                high = low + 1;
                state = A[high] - A[low];
            }
        }
        return max + 1;
    }
}