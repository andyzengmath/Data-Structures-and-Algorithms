class dfs {
    //10-26-20 review
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        int deleteLeft = 0;
        int deleteRight = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deleteLeft++;
            }
            if (c == ')') {
                if (deleteLeft > 0) {
                    deleteLeft--;
                } else {
                    deleteRight++;
                }
            }
        }
        
        dfs(s, 0, 0, deleteLeft, deleteRight, new StringBuilder());
        ans.addAll(set);
        return ans;
    }
    
    private void dfs(String s, int idx, int leftCount, int deleteLeft, int deleteRight, StringBuilder sb) {
        if (idx == s.length()) {
            if (deleteLeft == 0 && deleteRight == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            if (deleteLeft > 0) {
                dfs(s, idx + 1, leftCount, deleteLeft - 1, deleteRight, sb);
            }
            sb.append(c);
            dfs(s, idx + 1, leftCount + 1, deleteLeft, deleteRight, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (c == ')') {
            if (deleteRight > 0) {
                dfs(s, idx + 1, leftCount, deleteLeft, deleteRight - 1, sb);
            }
            if (leftCount > 0) {
                    sb.append(c);
                    dfs(s, idx + 1, leftCount - 1, deleteLeft, deleteRight, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
        } else {
            sb.append(c);
            dfs(s, idx + 1, leftCount, deleteLeft, deleteRight, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}