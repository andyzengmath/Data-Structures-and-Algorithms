public class twoPartition {
    public void sortColors(int[] nums) {
        int i = 0; j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[i] != 2) {
                i++;
            }
            while (i <= j && nums[j] == 2) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--
            }
        }

        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[i] != 1) {
                i++;
            }
            while (i <= j && nums[j] != 0) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}