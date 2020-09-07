public class revised {
    public float timeAngle(int h, int m) {
        float hh = (360 / 12) * h + (360f / (12 * 60)) * m;
        float mm = (360 / 60) * m;
        float result = Math.abs(mm - hh);
        return result > 180 ? (360 - result) : result;
    }
}
