
class LeetCode_53(object):
def maxSubArray(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    if len(nums) == 0:
        return 0
    
    max_sum, min_sum, pre_sum = -sys.maxsize, 0, 0
 
    for num in nums:
        pre_sum += num
        max_sum = max(max_sum, pre_sum - min_sum)
        min_sum = min(pre_sum, min_sum)
    return max_sum
    