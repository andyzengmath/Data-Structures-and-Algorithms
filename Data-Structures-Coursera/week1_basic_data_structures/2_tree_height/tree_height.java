import java.util.*;
import java.io.*;

public class tree_height {
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

	public class TreeHeight {
		int n;
		int parent[];
		int root;
		Node[] nodes;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}

			nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
			}

			for (int childIndex = 0; childIndex < n; childIndex ++) {
				int parentIndex = parent[childIndex];
				if (parentIndex == -1) {
					root = childIndex;
				} else {
					nodes[parentIndex].addChild(nodes[childIndex]);
				}
			}

		}

		int computeHeight() {
            // Replace this code with a faster implementation
			// int maxHeight = 0;
			// for (int vertex = 0; vertex < n; vertex++) {
			// 	int height = 0;
			// 	for (int i = vertex; i != -1; i = parent[i])
			// 		height++;
			// 	maxHeight = Math.max(maxHeight, height);
			// }
			// return maxHeight;

			Queue<Node> list = new LinkedList<Node>();
			list.add(nodes[root]);
			Node node = new Node();
			
			while (!list.isEmpty()) {
				node = list.remove();
				if (!node.children.isEmpty()) {
					for (Node e: node.children) {
						list.add(e);
					}
				}
			}

			int index = 0;
			for (int i = 0; i < n; i++) {
				if (nodes[i].equals(node)) {
					index = i;
					break;
				}
			}

			int height = 1;
			while (parent[index] != -1) {
				height ++;
				index = parent[index];
			}

			return height;
		}

		public class Node{
			List<Node> children;
			Node() {
				children = new ArrayList<Node>();
			}

			void addChild(Node child){
				children.add(child);
			}
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
