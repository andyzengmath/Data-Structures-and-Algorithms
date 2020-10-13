public class LintCode_5 {
    **
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     * Challenge: O(n) time, O(1) extra memory.
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        // quick select
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int index = left - 1;
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[right]) {
                    swap(nums, i, ++index);
                }
            }
            swap(nums, ++index, right);
            if (index == n - 1) {
                return nums[index];
            }
            if (index < n - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }

        }
        return -1;

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}