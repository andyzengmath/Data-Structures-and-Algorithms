class LeetCode_80:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        index = 0
        count = 1
        for i in range(1, len(nums)):
            if nums[index] == nums[i]:
                if count < 2:
                    index += 1
                    nums[index] = nums[i]
                    count += 1
            else:
                index += 1
                nums[index] = nums[i]
                count = 1
                
        return index + 1