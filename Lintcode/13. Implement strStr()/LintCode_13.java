public class LintCode_13 {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (target.equals("")) {
            return 0;
        }
        for (int i = 0; i < source.length(); i++) {
            for (int j = i; j < source.length(); j++) {
                String str = source.substring(i, j + 1);
                if (str.equals(target)) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}