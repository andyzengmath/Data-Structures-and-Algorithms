public class single {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 1;
        int countUp = 1;
        int countDown = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                countUp++;
                result = Math.max(result, countDown);
                countDown = 1;
            } else {
                countDown++;
                result = Math.max(result, countUp);
                countUp = 1;
            }
        }
       
        return Math.max(Math.max(result, countDown), countUp);
    }
}