class LeetCode_70:
    def climbStairs(self, n: int) -> int:
        matrix = [[1, 1], [1, 0]]
        result = self.power(matrix, n)
        return result[0][0]
    
    def multiply(self, a, b):
        c = [[0, 0],[0, 0]]
        for i in range(2):
            for j in range(2):
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] 
                
        return c
    
    def power(self, a, n):
        res = [[1,0], [0, 1]]
        while n > 0:
            if (n & 1) == 1:
                res = self.multiply(res, a)
            n >>= 1
            a = self.multiply(a, a)
        return res
        
   


// def fibsPower(self, fibs, n):
// if n == 1:
//     return fibs
// half = self.fibsPower(fibs, n / 2)
// ans = self.matrixProd(half, half)
// if n % 2 == 0:
//     return ans
// ans[0], ans[1], ans[2], ans[3] = ans[0] + ans[1], ans[0], ans[2] + ans[3], ans[2]
// return ans