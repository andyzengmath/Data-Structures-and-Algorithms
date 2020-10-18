class LeetCode_3:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0;
        need = set()
        left = 0
        right = 0
        max_len = 0
        
        while right < len(s):
            ch = s[right]
            right += 1
            while ch in need:
                need.remove(s[left])
                left += 1
            max_len = max(max_len, right - left)    
            need.add(ch)
        return max_len