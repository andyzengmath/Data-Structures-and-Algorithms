class simpler {
    public double myPow(double x, int n) {
        double base = n < 0 ? 1.0 / x : x;
        double res = 1.0;

        while (n != 0) {
            if (n % 2 != 0) res *= base;
            base *= base;
            n /= 2;
        }

        return res;
    }
}