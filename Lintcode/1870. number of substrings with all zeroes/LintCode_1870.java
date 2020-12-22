public class LintCode_1870 {
    /**
     * @param str: the string
     * @return: the number of substrings 
     */
    public int stringCount(String str) {
        // Write your code here.
        if (str == null) {
            return 0;
        }
        int j = 1, answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                continue;
            }
            j = Math.max(j, i + 1);
            while (j < str.length() && str.charAt(j) == '0') {
                j++;
            }
            answer += j - i;
        }
    return answer;
    }
    
    
}