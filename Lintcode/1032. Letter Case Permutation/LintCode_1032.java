public class LintCode_1032 {
    /**
     * @param S: a string
     * @return: return a list of strings
     */
    public List<String> letterCasePermutation(String S) {
        // write your code here
        List<String> res = new ArrayList<>();
        char[] chArr= S.toCharArray();
        dfs(chArr, 0, res);
        return res;
    }
    
    private void dfs(char[] chArr, int idx, List<String> res) {
        if (idx == chArr.length) {
            res.add(new String(chArr));
            return ;
        }
        dfs(chArr, idx + 1, res);
        if (chArr[idx] >= 'A') {
            if (chArr[idx] < 'a') {
                chArr[idx] = (char)(chArr[idx] + 32);
            } else {
                chArr[idx] = (char)(chArr[idx] - 32);
            }
            dfs(chArr, idx + 1, res);
        }
        
    }
}