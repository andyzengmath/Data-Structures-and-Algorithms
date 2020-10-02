public class LintCode_1354 {
    /** Leet-119
     * @param rowIndex: a non-negative index
     * @return: the kth index row of the Pascal's triangle
     */
    public List<Integer> getRow(int rowIndex) {
        // write your code here
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}