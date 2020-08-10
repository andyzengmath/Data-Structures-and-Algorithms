public class Kmp {
    public int strStr(String source, String target) {
        if (target.length() == 0) {
            return 0;
        }

        int a = 0, b = 0;
        char[] sourceC = source.toCharArray();
        char[] targetC = target.toCharArray();
        int[] next = getNext(targetC);
        while (a < sourceC.length && b < targetC.length) {
            if (b == -1 || sourceC[a] == targetC[b]) {
                a++;
                b++;
            } else {
                b = next[b];
            }
        }

        if (b == targetC.length) {
            return a - b;
        }

        return -1;
    }

    protected int[] getNext(char[] p) {
        int[] next = new int[p.length];
        int a = -1, b = 0;
        next[0] = -1;
        while (b < p.length - 1) {
            if (a = -1 || p[a] = p[b]) {
                a++;
                b++;
                next[b] = a;
            } else {
                a = next[a];
            }
        }
        return next;
    }
}