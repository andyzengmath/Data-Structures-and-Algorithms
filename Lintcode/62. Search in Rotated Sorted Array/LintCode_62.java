public class LintCode_62 {
    /** LeetCode-33
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return -1;
        } else if (A.length == 1) {
            return A[0] == target ? 0 : -1;
        }

        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[0] <= A[mid]) {
                if (A[0] <= target && target < A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;


    }
}