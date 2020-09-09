public class LintCode_813 {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
        int l = A.length;
        int[] res = new int[l];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < l; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }
}