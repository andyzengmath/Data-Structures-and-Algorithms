public class LintCode_479 {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i ++) {
            if (first != Integer.MIN_VALUE){
                
                int entry = nums[i];
                if (entry > second || second == Integer.MIN_VALUE){
                    if (entry > first) {
                        second = first;
                        first = entry;
                    } else {
                        second = entry;
                    }
                }
            } else {
                first = nums [i];
            }
        }

        return second;
    }

    public void test(){
        int[] testList = {1,3,2, 4};
        System.out.println(secondMax(testList));
    }

    public static void main(String args[]){
        LintCode_479 sol = new LintCode_479();
        sol.test();
    }
}