class LeetCode_75:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index, left, right = 0, 0 , len(nums) - 1
        # be careful, index < right is not correct
        while (index <= right):
            if nums[index] == 0:
                nums[index], nums[left] = nums[left], nums[index]
                left += 1
                index += 1 # move to next number
            elif nums[index] == 2:
                nums[index], nums[right] = nums[right], nums[index]
                right -= 1
            else: # == 1, skip
                index += 1
                
        
        
        