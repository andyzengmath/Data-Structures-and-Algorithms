import java.util.*;
import java.io.*;
// n-order, pre-order and post-order traversals
public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			postOrderRecursive(result, 0);     
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			preOrderRecursive(result, 0);            
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
            postOrderRecursive(result, 0);           
			return result;
		}

		void inOrderRecursive(ArrayList<Integer> result, int i) {
			if (left[i] != -1)  {
				inOrderRecursive(result, left[i]);
			}
			result.add(key[i]);
			if (right[i] != -1) {
				inOrderRecursive(result, right[i]);
			}
		}

		void postOrderRecursive(ArrayList<Integer> result, int i) {
			if (left[i] != -1)  {
				postOrderRecursive(result, left[i]);
			}
			if (right[i] != -1) {
				postOrderRecursive(result, right[i]);
			}
			result.add(key[i]);
		}

		void preOrderRecursive(ArrayList<Integer> result, int i) {
			result.add(key[i]);
			if (left[i] != -1)  {
				preOrderRecursive(result, left[i]);
			}
			if (right[i] != -1) {
				preOrderRecursive(result, right[i]);
			}
			
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
