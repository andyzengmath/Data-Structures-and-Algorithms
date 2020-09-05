public class LintCode_702 {
    /**
     * @param s1: the 1st string
     * @param s2: the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {
        // hash
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            if (!set.contains(s2.charAt(i))) {
                set.add(s2.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!set.contains(s1.charAt(i))) {
                sb.append(s1.charAt(i));
            } else {
                if (!set2.contains(s1.charAt(i))) {
                    set2.add(s1.charAt(i));
                }
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!set2.contains(s2.charAt(i))) {
                sb.append(s2.charAt(i));
            }
        }

        return sb.toString();
    }
}
