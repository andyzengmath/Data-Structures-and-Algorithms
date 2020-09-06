public class LintCode_737 {
    /**
     * @param Matrix: the input
     * @return: the element which appears every row
     */
    public int FindElements(int[][] Matrix) {
        // write your code here
        if (Matrix == null || Matrix.length == 0 || Matrix[0].length == 0) {
            return -1;
        } else if (Matrix[0].length == 1) {
            return Matrix[0][0];
        }

        int w = Matrix[0].length, l = Matrix.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < w; i++) {
            list.add(Matrix[0][i]);
        }
        for (int j = 1; j < l; j++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int k = 0; k < w; k++) {
                set.add(Matrix[j][k]);
            }
            for (int m = 0; m < list.size(); m++) {
                if (!set.contains(list.get(m))) {
                    list.remove(list.get(m));
                }
            }
        }
        return list.get(0);
    }
}