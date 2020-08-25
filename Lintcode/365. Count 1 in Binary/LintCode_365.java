public class LintCode_365 {
    /* LeetCode 191
     * @param num: An integer
     * @return: An integer
     * If the integer is n bits with m 1 bits. Can you do it in O(m) time?
     */
    public int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}