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
}