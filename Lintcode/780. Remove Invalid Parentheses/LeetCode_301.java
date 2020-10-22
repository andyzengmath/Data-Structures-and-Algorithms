class LeetCode_301 {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        dfs(s, 0, l, r, set);
        List<String> res = new ArrayList<>(set);
        return res;
    }
    
    public void dfs(String s, int index, int l, int r, HashSet<String> set) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                set.add(s);
            }
        }
        for (int i = index; i < s.length(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(s, 0, i);
            sb.append(s.substring(i + 1));
            String cur = sb.toString();
            if (l > 0 && s.charAt(i) == '(') {
                dfs(cur, i, l - 1, r, set);
            } else if (r > 0 && s.charAt(i) == ')') {
                dfs(cur, i, l, r - 1, set);
            }
        }
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) ==')') {
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0;
    }
}