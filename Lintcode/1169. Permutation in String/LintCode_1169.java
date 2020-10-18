public class LintCode_1169 {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: if s2 contains the permutation of s1
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();

        for (char ch: s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;

        while (right < s2.length()) {
            char ch = s2.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (need.get(ch).compareTo(window.get(ch)) == 0) {
                    valid++;
                }
            }
            
            while (valid == need.size()) {
                if (right - left == s1.length()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) < need.get(d)) {
                        valid--;
                    }
                }
            }
        }
        return false;
    }
}