public class LintCode_172 {
    /* Frequently asked question ++
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here、
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        int pointer = A.length - 1;
        while (i <= pointer) {
            if (A[i] == elem) {
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
}