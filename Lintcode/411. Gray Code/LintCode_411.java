public class LintCode_411 {
    /**
     * @param n: a number
     * @return: Gray code
     */

    public List<Integer> grayCode(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>(){{add(0);}};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
                
            }
            head <<= 1;
        }
        return res;
        
    }
}