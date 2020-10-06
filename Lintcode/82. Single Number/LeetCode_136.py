class LeetCode_136:
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for i in range(len(nums)):
            result ^= nums[i]
        return result
    # return reduce(lambda x, y: x ^ y, nums);