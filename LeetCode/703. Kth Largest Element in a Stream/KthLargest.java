class KthLargest {
    private PriorityQueue<Integer> pq;
    private int fixed_k;
    public KthLargest(int k, int[] nums) {
        fixed_k = k;
        pq = new PriorityQueue<>(k);
        for (int val: nums) {
            add(val);
        }
    }
    
    public int add(int val) {
        if (pq.size() < fixed_k) {
            pq.add(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */