public class LintCode_347 {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int[] times = new int[26];

        for (char c: p.toCharArray()) {
            times[c - 'a']++;
        }

        int l = 0, r = -1;
        while (l < s.length()) {
            if (r - l + 1 == p.length()) {
                list.add(l);
            }
            if (r + 1 < s.length() && times[s.charAt(r + 1) - 'a'] > 0) {
                r++;
                times[s.charAt(r) - 'a']--;
            } else {
                times[s.charAt(l) - 'a']++;
                l++;
            }
        }

        return list;
    }
}