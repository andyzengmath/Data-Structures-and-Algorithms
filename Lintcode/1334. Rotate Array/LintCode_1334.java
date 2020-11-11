public class LintCode_1334 {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    // O(n) space O(1) time  Using Cyclic Replacements
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int curr = start;
            int prev = nums[curr];
            do {
                int next = (curr + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                count++;
            }
            while (start != curr);
        }
        return nums;
    }
    // reverse
    public int[] rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}