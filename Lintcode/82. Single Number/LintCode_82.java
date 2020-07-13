public class LintCode_82 {
    /**
     * @param A: An integer array
     * @return: An integer
     * c.f. LeetCode 136
     */
    public int singleNumber(int[] A) {
        // write your code here
        int result = 0;
        for (int i = 0; i < A.length; i ++) {
            result = result^A[i];
        }
        return result;
    }
}