public class LintCode_539 {
    /**
     * @param nums: an integer array
     * @return: nothing
     * Notice: 1)You must do this in-place without making a copy of the array.
        2Minimize the total number of operations.
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        //double pointer O(n) time O(1) space
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = 0;
        while (right <= nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}