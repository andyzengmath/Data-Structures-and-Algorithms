public class LintCode_373 {
    /* leetcode 905
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0, end = nums.length - 1;
        
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }

    public static void swap(int[] nums, int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}