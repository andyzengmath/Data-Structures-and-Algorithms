public class Solution {
    /**
     * @param s: a string
     * @param k: a integer
     * @return: return a integer
     */
    public int characterReplacement(String s, int k) {
        // write your code here
        if (s == null) {
            return 0;
        }
        int j = 0, answer = 0, maxFreq = 0, count;
        HashMap<Character, Integer> counter = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && j - i - maxFreq <= k) {
                count = counter.getOrDefault(s.charAt(j), 0) + 1;
                counter.put(s.charAt(j), count);
                maxFreq = Math.max(maxFreq, count);
                j++;
            }
            if (j - i - maxFreq > k) {
                answer = Math.max(answer, j - i - 1);
            } else {
                answer = Math.max(answer, j - i);
            }
            
            count = counter.get(s.charAt(i)) - 1;
            counter.put(s.charAt(i), count);
            
            maxFreq = getMaxFreq(counter);
        }
        return answer;
    }
}