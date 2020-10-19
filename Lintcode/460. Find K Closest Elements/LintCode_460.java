public class LintCode_458 {
    /** leetcode 658  different in sorting
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right --;
            } else {
                left ++;
            }
            removeNums --;
        }

        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            if (x - arr[left] > arr[right] - x) {
                res[k - 1 - i] = arr[left];
                left = left + 1;
            } else {
                res[k - 1 - i] = arr[right];
                right = right - 1;
            }
            i++;
        }
        // Arrays.copyOfRange(left, left + k);

        return res;
    }
}