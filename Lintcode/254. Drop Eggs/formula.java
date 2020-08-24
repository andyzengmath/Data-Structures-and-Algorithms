public class formula {
    public int dropEggs(int n) {
        long x = 2 * (long)n;
        long sq = (long)Math.sqrt(x);
        if (sqrt * (sqrt + 1) >= x) {
            return (int)sq;
        } else {
            return (int)(sqrt + 1);
        }
    }
}