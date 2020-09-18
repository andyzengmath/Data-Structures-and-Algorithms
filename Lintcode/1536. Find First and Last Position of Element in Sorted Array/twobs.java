public class twobs {
    public List<Integer> searchRange(List<Integer> nums, int target) {
        // Write your code here.
        if (nums == null || nums.size() == 0) {
            return Arrays.asList(-1,-1);
        }
        int left = firstPosition(nums, target);
        
        if (left == -1) {
            return Arrays.asList(-1,-1);
        }
        
        int right = lastPosition(nums, target);
        
        return Arrays.asList(left, right);
    }
    
    
    private int firstPosition(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                right = mid - 1;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (left == nums.size() || nums.get(left) != target) {
            return -1;
        }
        return left;
    }

    
    private int lastPosition(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                left = mid + 1;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}