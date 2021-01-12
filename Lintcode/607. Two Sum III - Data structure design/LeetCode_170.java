class TwoSum {
    private ArrayList<Integer> nums;
    private boolean is_sorted;
    /** Initialize your data structure here. */
    public TwoSum() {
        this.nums = new ArrayList<Integer>();
        this.is_sorted = false;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.nums.add(number);
        this.is_sorted = false;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (!this.is_sorted) {
            Collections.sort(this.nums);
            this.is_sorted = true;
        }
        int low = 0, high = this.nums.size() - 1;
        while (low < high) {
            int sum = this.nums.get(low) + this.nums.get(high);
            if (sum < value) {
                low++;
            } else if (sum > value) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */