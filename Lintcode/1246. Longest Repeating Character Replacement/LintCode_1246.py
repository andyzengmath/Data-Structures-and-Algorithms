class Solution:
    """
    @param s: a string
    @param k: a integer
    @return: return a integer
    """
    def characterReplacement(self, s, k):
        # write your code here
        counter = {}
        answer = 0
        j = 0
        max_freq = 0
        for i in range(len(s)):
            while j < len(s) and j - i - max_freq <= k:
                counter[s[j]] = counter.get(s[j], 0) + 1
                max_freq = max(max_freq, counter[s[j]])
                j += 1
            if j - i - max_freq > k:
                answer = max(answer, j - i - 1)
            else:
                answer = max(answer, j - i)
            
            counter[s[i]] -= 1
            max_freq = max(counter.values())
        return answer