public class LintCode_187 {
    /** Leet 134
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                start = i + 1;
                curr_tank = 0;
            }
        }
        
        return total_tank >= 0 ? start : -1;
    }
}