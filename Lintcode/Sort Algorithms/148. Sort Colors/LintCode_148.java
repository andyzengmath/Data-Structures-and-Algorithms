public class LintCode_148 {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     * Challenge

    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with an one-pass algorithm using only constant space?

     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0;
        int index = 0;
        int right = nums.length - 1;

        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                left ++;
                index ++;
            } else if (nums[index] == 2) {
                swap(nums, index, right);
                right --;
            } else {
                index ++;
            }
        }
    }

    public void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}