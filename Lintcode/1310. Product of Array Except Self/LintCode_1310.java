public class Lintcode_1310 {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        if (nums == null) return null;
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];

        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }
        
        r[len - 1] = 1;
        for (int i = len - 2; i >=0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }
        
        for (int i = 0; i < len; i++) {
            l[i] = l[i] * r[i];
        }
        return l;

       
        

    }
}