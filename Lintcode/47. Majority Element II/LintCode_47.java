public class LintCode_47 {
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        
        if (nums == null || nums.size() == 0) return -1;
        
        int candidateA = nums.get(0);
        int candidateB = nums.get(0);
        int countA = 0, countB = 0;
        
        for (int num: nums) {
            if (num == candidateA) {
                countA++;
                continue;
            }
            if (num == candidateB) {
                countB++;
                continue;
            }
            
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }
        
        countA = 0;
        countB = 0;
        for (int num: nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }
        if (countA > nums.size() / 3) return candidateA;
        if (countB > nums.size() / 3) return candidateB;
        return -1;
    }
}