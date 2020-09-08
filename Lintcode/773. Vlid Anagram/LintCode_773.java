public class LintCode_773 {
    /**
     * @param s: string s
     * @param t: string t
     * @return: Given two strings s and t, write a function to determine if t is an anagram of s.
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     * You may assume the string contains only lowercase alphabets.
     */
    public boolean isAnagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}