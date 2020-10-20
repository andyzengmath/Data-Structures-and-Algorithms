class LeetCode_34 {
    // 10-20-20 review
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirst(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = findLast(nums, target);
        return new int[]{firstPosition, lastPosition};
    }
    
    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // node [left, right] left closed, right closed terminal condition [right, left]
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left != nums.length && nums[left] == target) {
            return left; // check the case left bigger than length, or not found
        }
        return -1;
    }
    
    public int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left != 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }
    
}