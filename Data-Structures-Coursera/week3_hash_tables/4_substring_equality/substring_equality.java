import java.util.*;
import java.io.*;

public class substring_equality {


	public class Solver {
		private String s;
		private long[] h1;
		private long[] h2;
		private int m1;
		private int m2;
		private int x1;
		private int x2;

		

		public Solver(String s) {
			this.s = s;
			h1 = new long[s.length() + 1];
			h2 = new long[s.length() + 1];
			m1 = (int)Math.pow(10, 9) + 7;
			m2 = (int)Math.pow(10, 9) + 9;
			x1 = 1;
			x2 = 9; 
			
			precomputeHashes(h1, m1, x1);
			precomputeHashes(h2, m2, x2);
			
		}
		public boolean ask(int a, int b, int l) {
			long z1= (long)Math.pow(a, l) % m1;
			long z2= (long)Math.pow(a, l) % m2;
			if ((h1[a + l] - z1 * h1[a] % m1) % m1 == (h1[b + l] - z1 * h1[b] % m1) % m1) {
				if ((h2[a + l] - z2 * h2[a] % m2 + m2) % m2 == (h2[b + l] - z2 * h2[b] % m2 + m2) % m2) {
					return true;
				}
			}
			return false;
		}

		private void precomputeHashes(long[] h, int p, int x) {
			long[] S = new long[s.length()];
			for (int i = 0; i < s.length(); i++){
				S[i] = s.charAt(i);
			}
			h[0] = 0;
			for (int i = 1; i <= s.length(); i++) {
				h[i] = (x * h[i - 1] % p + S[i - 1] % p) % p;
			}
		}
	}

	



	public void run() throws IOException {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		int q = in.nextInt();
		Solver solver = new Solver(s);
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = in.nextInt();
			out.println(solver.ask(a, b, l) ? "Yes" : "No");
		}
		out.close();
	}

	static public void main(String[] args) throws IOException {
	    new substring_equality().run();
	}

	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
