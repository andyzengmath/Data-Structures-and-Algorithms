public class LintCode_426 {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];
    List<String> ans = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;

    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ip = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ip.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ip.append('.');
                    }
                }
                ans.add(ip.toString());
            }
            return;
        }
        
        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}