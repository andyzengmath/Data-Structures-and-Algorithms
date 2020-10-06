public class LintCode_83 {
    /** Leet 137
     * one pass, constant memory
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] nums) {
        // write your code here
        int once = 0, twice = 0;
        for (int num: nums) {
            once = (once ^ num) & ~twice;
            twice = (twice ^ num) & ~ once;
        }
        return once;
    }
}