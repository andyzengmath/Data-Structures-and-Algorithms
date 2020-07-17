public class LintCode_84 {
    /**
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        int two = 0;
        int first = 0;
        int second = 0;

        for (int i = 0; i < A.length; i++) {
            two = two ^ A[i];
        }

        int lastBit = two - (two & (two - 1));
        // or int lastBit = two & (-two)

        for (int i = 0; i< A.length; i++) {
            if ((lastBit & A[i]) == 0) {
                first ^= A[i];
            } else {
                second ^= A[i];
            }
        }
        result.add(first);
        result.add(second);

        return result;
    }
}