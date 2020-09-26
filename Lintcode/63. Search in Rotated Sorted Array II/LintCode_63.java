public class LintCode_63 {
    /** slow!
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid] ) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }   
        }
        return false;
    }
}