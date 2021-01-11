class LeetCode_852:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left = 0
        right = len(arr) - 1
        
        while (left + 1 < right):
            mid = left + (right - left) // 2
            if arr[mid] > arr[mid + 1]:
                right = mid
            else:
                left = mid
        if arr[left] > arr[right]:
            return left
        else: 
            return right