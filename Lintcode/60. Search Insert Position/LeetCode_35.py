class LeetCode_35(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        length = len(nums)
        if len == 0 or nums[0] >= target:
            return 0
        elif nums[length - 1] < target:
            return length;
        
        left = 0
        right = length - 1
        
        while left < right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        return left
        
        