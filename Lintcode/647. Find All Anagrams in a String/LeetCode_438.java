class LeetCode_438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<Integer>();
        
        for (char ch: p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).compareTo(need.get(ch)) == 0) {
                    valid++; //note: can't use == 用 compareTo() 比较，原因是自动装箱默认范围是 -128 -127，超过会创建新的对象，可以看下这个https://my.oschina.net/miwang/blog/730343
                }
            }
            while (valid == need.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) < need.get(d)) {
                        valid--;
                    }
                }
            }
        }
        return res;
    }
}