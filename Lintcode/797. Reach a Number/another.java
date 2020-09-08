public class another {
    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 1, pos = 0;
        while (pos < target) {
            pos += step;
            step++;
        }
        step--;
        if (pos == target) return step;

        pos -= target;
        if (pos % 2 == 0) {
            return step;
        } else if ((step + 1) % 2 == 1) {
            return step + 1;
        } else {
            return step + 2;
        }
    }
}