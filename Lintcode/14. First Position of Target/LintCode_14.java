public class LintCode_14 {
    /** For a given sorted array (ascending order) and a target number, 
     * find the first index of this number in O(log n) time complexity.
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int lo = 0, high = nums.length;
        while (lo < high) {
            int m = (lo + high) / 2;
            if (nums[m] < target) {
                lo = m + 1;
            } else {
                high = m;
            }
        }
        
        if (nums[lo] == target) {
            return lo;
        }
        
        return -1;
    }
    // Jiuzhang
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] = target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] = target) {
            return end;
        }
        return -1;
    }
}