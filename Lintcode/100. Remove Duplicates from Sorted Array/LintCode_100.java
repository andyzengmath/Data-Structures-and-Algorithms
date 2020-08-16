public class LintCode_100 {
    /*
     * @param nums: An ineger array
     * @return: An integer
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[result]) {
                nums[++result] = nums[i];
            }
        }
        return result + 1;
    }
}