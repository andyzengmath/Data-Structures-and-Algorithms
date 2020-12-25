public class LintCode_761 {
    /**
     * @param arr:  an array of non-negative integers
     * @return: minimum number of elements
     */
    public int minElements(int[] arr) {
        // write your code here
        int halfSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            halfSum = halfSum + arr[i];
        }
        halfSum = halfSum / 2;
        Arrays.sort(arr);
        int res = 0, currSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            currSum += arr[i];
            res++;
            if (currSum > halfSum) {
                return res;
            }
        }
        return res;
    }
}