public class LintCode_458 {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        if (target < num[0] || target > nums[end]) {
            return -1;
        }
        
        while ( start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid
            }
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}