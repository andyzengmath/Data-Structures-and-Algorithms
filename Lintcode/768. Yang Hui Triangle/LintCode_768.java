public class LintCode_768 {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public List<List<Integer>> calcYangHuisTriangle(int n) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
    
        if (n == 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(result.get(i-1).get(j - 1) + result.get(i-1).get(j));
            }
            if (i > 0) temp.add(1);
            result.add(temp);
        }

        return result;
    }
}