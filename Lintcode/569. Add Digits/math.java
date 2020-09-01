public class math {
    // num = a0 + a1 10 + a2 100 + ... + ak * 10^k = (a0 + a1 + ... + ak) + 9(a1 + a2 + ... + ak) + 99(a2 + ... + ak) + ... + (10^k - 1)ak
    public int addDigits(int num) {
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }
}