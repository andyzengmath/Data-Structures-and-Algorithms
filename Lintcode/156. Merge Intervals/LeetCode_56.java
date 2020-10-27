class Solution {
    //10-26-20 review
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        LinkedList<int[]> res = new LinkedList<>(); //have to use LinkedList in order to use getLast();
        for (int[] interval: intervals) {
            if (res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]); //here linkedlist to array 
    }
}