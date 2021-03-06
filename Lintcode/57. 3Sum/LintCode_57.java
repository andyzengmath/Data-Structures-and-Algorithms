public class LintCode_57 {
    /** Leet 15
     * Runtime: 19 ms, faster than 80.02% of Java online submissions for 3Sum.
        Memory Usage: 43.1 MB, less than 5.04% of Java online submissions for 3Sum.
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return results;
        }
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length -1;
            int target = - nums[i];
            twoSum(nums, left, right, target, results);
        }

        return results;
    }

    public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                left++;
                right--;
                
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
            
        } 
    }
}