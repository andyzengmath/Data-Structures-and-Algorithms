class LeetCode_15 {
    // 10-19-20 review
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // note nums[i] might have iterations, need pass
            }
            int k = - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == k) {
                    List<Integer> triple = new ArrayList<Integer>();
                    triple.add(nums[i]);
                    triple.add(nums[left]);
                    triple.add(nums[right]);
                    res.add(triple);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; // note we must maintain left < right
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < k) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                } else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                }
            }
        }
        return res;
    }
}