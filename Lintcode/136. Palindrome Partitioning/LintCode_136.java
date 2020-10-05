public class LintCode_136 {
    /* Leet 131
    related: lint 108 Palindrome partitioning II
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        int len = s.length();
        List<List<String>> result = new ArrayList<>();
        if (len == 0) return result;
        Deque<String> stack = new ArrayDeque<>();

        backtracing(s, 0, len, stack, result);
        return result;
    }

    private void backtracing(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracing(s, i + 1, len, path, res);
            path.removeLast();
        }
    }
    
    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}