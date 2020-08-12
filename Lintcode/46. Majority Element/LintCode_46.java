public class LintCode_46 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     * O(n) time and O(1) extra space
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        //Boyer–Moore majority vote algorithm
        int curMajor = 0;
        int count = 0; 

        for (Integer i: nums) {
            if (count == 0) {
                curMajor = i;
            }

            if (i == curMajor) {
                count++;
            } else {
                count--;
            }
        }

        return curMajor;

    }
}