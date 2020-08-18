public class newton {
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException();
        else if (x <= 1) {
            return x;
        }

        double guess = 1.0;
        while (Math.abs(x - guess * guess) > 0.1) {
            guess = (x / guess + guess) / 2; // f(x) = x^2 - n, n is the given number, then use newton's method
        }
        return (int)guess;
    }
}