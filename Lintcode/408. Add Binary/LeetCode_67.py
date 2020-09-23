class LeetCode_67:
    def addBinary(self, a: str, b: str) -> str:
        res = ''
        add = 0
        d = len(b) - len(a)
        a = '0' * d + a
        b = '0' * -d + b
        
        for i, j in zip(a[::-1], b[::-1]):
            sum = int(i) + int(j) + add
            res = str(sum % 2) + res
            add = sum // 2
        return '1' + res if add else res