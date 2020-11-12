class LeetCode_202 {
    //review 11-12-20
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNextHappy(n);
        }
        return n == 1;
    }
    
    private int getNextHappy(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            n /= 10;
            sum += rem * rem;
        }
        return sum;
    }
}