class LeetCode_61:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0
        elif m == 1 and n == 1:
            return 1
        
        if m >= n:
            m, n = n, m
        
        numerator = 1
        for i in range(1, m):
            numerator *= i
            
        denominator = 1
        for j in range(n, m + n - 1):
            denominator *= j
            
        return denominator // numerator