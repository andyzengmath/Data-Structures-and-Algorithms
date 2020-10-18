public class LintCode_402 {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        int n = A.length;
        int maxSum = A[0], sum = 0;
        int first = 0, last = 0;
        int bg = 0;
        for (int i = 0; i < n; i++) {
            if (sum >= 0) {
                sum += A[i];
            } else {
                bg = i;
                sum = A[i];
            }
            if (maxSum < sum) {
                maxSum = sum;
                first = bg;
                last = i;
            }
        }

        List<Integer> ans = new ArrayList();
        ans.add(first);
        ans.add(last);
        return ans;
    }
}