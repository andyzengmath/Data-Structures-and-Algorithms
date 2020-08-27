public class LeetCode_674 {
    // LintCode 397
    public int findLengthOfLCIS(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 1;
        int countUp = 1;
        

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                countUp++;
                result = Math.max(result, countUp); 
            } else {
                countUp = 1;
            }
        }
       
        return result;
    }
}