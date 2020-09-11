public class shorter {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}