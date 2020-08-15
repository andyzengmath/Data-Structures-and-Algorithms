public class LintCode_80 {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        
        int l = 0, r = nums.length - 1, mid = ((nums.length + 1)/ 2);
        while (true) {
            int nth = partition(nums, l, r);
            if (nth + 1 == mid) {
                return nums[nth];
            } else if (nth + 1 > mid) {
                r = nth - 1;
            } else {
                l = nth + 1;
            }
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int l = start, r = end, pivot = nums[start];
        while (l <= r) {
            while (l <= r && nums[l] <= pivot) {
                l++;
            }
            while (l <= r && nums[r] >= pivot) {
                r--;
            }
            if (l <= r) {
                swap(nums, l++, r--);
            }
        }
        swap(nums, start, r);
        return r;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}