public class LintCode_945 {
    /** Leet 621
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        // write your code here
        int[] counts = new int[26];
        for (char c: tasks) {
            counts[c - 'A'] += 1;
        }
        int max = 0;
        for (int count: counts) {
            max = Math.max(max, count);
        }
        int maxCount = 0;
        for (int count: counts) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }
}