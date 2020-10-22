class Solution {
    // 10-20-22 review
    public int trap(int[] height) {
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        } // note boundary and height comparison
        for (int i = height.length - 2; i >= 1; i--) { 
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        
        for (int i = 1; i < height.length - 1; i++) {
            if (Math.min(leftMax[i], rightMax[i]) > height[i]) {
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return sum;
    }
}