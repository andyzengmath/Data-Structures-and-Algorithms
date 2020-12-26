public class LintCode_190 {
    /** Same of code of LintCode 52
     * @param nums: An array of integers
     * @return: nothing
     */
    public int[] nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        int i = len - 2;
        
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
            
        }
        
        if (i >= 0) {
                int j = len - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
        
        reverse(nums, i + 1, len - 1);
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}