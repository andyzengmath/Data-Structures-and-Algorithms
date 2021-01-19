public class LintCode_918 {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }   
    
    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
    
}