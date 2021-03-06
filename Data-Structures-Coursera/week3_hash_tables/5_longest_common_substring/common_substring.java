import java.util.*;
import java.io.*;
// not pass #8 with x1 =1 x2 =9
public class common_substring {
    public class Answer {
        int i, j, len;
        Answer(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }

    public Answer solve(String s, String t) {
        Answer ans = new Answer(0, 0, 0);
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < t.length(); j++)
                for (int len = 0; i + len <= s.length() && j + len <= t.length(); len++)
                    if (len > ans.len && s.substring(i, i + len).equals(t.substring(j, j + len)))
                        ans = new Answer(i, j, len);
        return ans;
    }

    private static long polyHash(long[] S, int p, int x) {
        long hash = 0;
        for (int i = S.length - 1; i >= 0; i--) {
            hash = (hash * x + S[i]) % p;
        }
        return hash;
    }

    private static long[] precomputeHashes(long[] T, int length, int p, int x) {
        long[] H = new long[T.length - length + 1];
        long[] S = Arrays.copyOfRange(T, T.length - length, T.length);

        H[T.length - length] = polyHash(S, p, x);
        long y = 1;
        for (int i = 1; i <= length; i++) {
            y = (y * x) % p;
        }
        for (int i = T.length - length - 1; i >= 0; i--) {
            H[i] = ((x * H[i+1] + T[i] % p - y * T[i+length]) % p + p) % p;
        }
        return H;
    }

    

    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        in.lines().forEach(line -> {
            StringTokenizer tok = new StringTokenizer(line);
            String s = tok.nextToken();
            String t = tok.nextToken();
            Answer ans = solve(s, t);
            out.format("%d %d %d\n", ans.i, ans.j, ans.len);
        });
        out.close();
    }

    static public void main(String[] args) {
        new common_substring().run();
    }
}
