class LeetCode_74:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        if n == 0:
            return False
        
        left, right = 0, m * n - 1
        
        while left < right:
            mid = (left + right) // 2
            if matrix[mid // n][mid % n] == target:
                return True
            elif matrix[mid // n][mid % n] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        if matrix[left // n][left % n] == target:
            return True
        else:
            return False
            
            