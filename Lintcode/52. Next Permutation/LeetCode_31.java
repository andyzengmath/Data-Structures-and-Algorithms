class LeetCode_31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        
        if (i >= 0) { // node condition for i
            int j = len - 1; // put j inside the loop
            while (j >= 0) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1); // outside the loop
        
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