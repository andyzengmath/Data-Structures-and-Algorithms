class double(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = "1"
        if n == 1:
            return s
        
        for i in range(1, n):
            s = sayCount(s)
        return s
    
    def sayCount(self, s):
        curr = 0;
        string = ""
        for i in range(len(s)):
            if s[i] != s[curr]:
                string + str(i - curr)
                string + s[curr]
                curr = i
        string + str(len - curr)
        string + s(curr)
        
        return string
                
                
                
        