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

    // Jiuzhang Template
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) return nums[k];

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}

 