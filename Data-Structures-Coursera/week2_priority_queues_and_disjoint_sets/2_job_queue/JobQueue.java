import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;
    private Processor[] processors;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        processors = new Processor[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            processors[i] = new Processor(i, 0);
        }

        for (int i = 0; i < jobs.length; i++) {
            assignedWorker[i] = processors[0].number;
            startTime[i] = processors[0].start;
            processors[0].start += jobs[i];
            siftDown(0);
        }
    }

    private int leftChild(int n) {
        return 2 * n + 1;
    }

    private int rightChild(int n) {
        return 2 * n + 2;
    }

    private void siftDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        if (l < processors.length && (processors[l].start < processors[minIndex].start)) {
            minIndex = l;
        }
        int r = rightChild(i);
        if (r < processors.length && (processors[r].start < processors[minIndex].start)) {
            minIndex = r;
        }
        if (i != minIndex) {
            Processor temp = processors[i];
            processors[i] = processors[minIndex];
            processors[minIndex] = temp;
            siftDown(minIndex);
        }
    }

    private class Processor{
        int number;
        long start;
        Processor(int number, long start) {
            this.number = number;
            this.start = start;
        }
    }



    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
