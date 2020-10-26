class LintCode_776 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        Map<Character, Character> map = new HashMap<Character, Character>();
        char[] nums = new char[]{'0', '1', '8', '6', '9'};
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        if (n % 2 == 0) {
            dfs(n, "", res, map, nums); 
        } else {
            dfs(n, "0", res, map, nums);
            dfs(n, "1", res, map, nums);
            dfs(n, "8", res, map, nums); 
        }
        return res;
    }
    
    private void dfs(int n, String s, List<String> res, Map<Character, Character> map, char[] nums) {
        if (s.length() == n) {
            if (s.length() > 1) {
                if (s.charAt(0) != '0') {
                    res.add(s);
                }
            } else if (s.length() == 1) {
                res.add(s);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            String s1 = nums[i] + s + map.get(nums[i]);
            dfs(n, s1, res, map, nums);
        }
    }
}