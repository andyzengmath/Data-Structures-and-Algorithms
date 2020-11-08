public class LintCode_1380 {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    private int count;
    private PriorityQueue<Integer> maxheap, minheap;
    
    public int[] medianII(int[] nums) {
        // write your code here
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
            res[i] = findMedian();
        }
        return res;
        
    }
    
    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        if ((count & 1) !=  0) {
            maxheap.add(minheap.poll());
        }
    }
    
    public int findMedian() {
        return maxheap.peek();
    }
}