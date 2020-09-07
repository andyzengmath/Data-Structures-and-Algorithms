public class LintCode_759 {
    /**
     * @param h: hours
     * @param m: minutes
     * @return: angle between hour hand and minute hand at X:Y in a clock
     */
    public float timeAngle(int h, int m) {
        // write your code here
        float mAngle = m * 6;
        float hAngle = (h + m / 60.0f) * 30;
        float res = Math.abs(mAngle - hAngle);
        res -= Math.floor(res / 360) * 360;
        if (res > 180) res = 360 - res;
        return res;
    }
}
