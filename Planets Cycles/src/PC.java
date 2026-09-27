import java.io.*;
import java.util.StringTokenizer;

public class PC {
    static int[] next;
    static int N;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        N = kattio.nextInt();
        next= new int[N];
        for (int i = 0; i < N; i++) {
            next[i] = kattio.nextInt()-1;
        }
        int[] cycle = new int[N];
        int[] clen = new int[N];
        int[] disttoc = new int[N];
        boolean[] visited = new boolean[N];
        boolean[] inCycle = new boolean[N];
        // Pre-compute for all components
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int[] ans = floyd(i);
                int cycleStart = ans[0];
                int cycleLength = ans[1];
                // Mark all nodes in the cycle
                int curr = cycleStart;
                for (int j = 0; j < cycleLength; j++) {
                    inCycle[curr] = true;
                    cycle[curr] = cycleStart;
                    clen[curr] = cycleLength;
                    disttoc[curr] = 0;
                    visited[curr] = true;
                    curr = next[curr];
                }
                // For all nodes leading to this cycle
                curr = i;
                while (!visited[curr]) {
                    int temp = curr;
                    int dist = 0;
                    while (!inCycle[temp]) {
                        temp = next[temp];
                        dist++;
                    }
                    disttoc[curr] = dist;
                    clen[curr] = clen[temp];
                    visited[curr] = true;
                    curr = next[curr];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            kattio.print(disttoc[i] + clen[i] + " ");
        }
        kattio.close();
    }

    public static int[] floyd(int start){
        int[] ans = new int[2]; //first node, cycle length
        int a = next[start];
        int b = next[next[start]];
        while(a!=b){
            a = next[a];
            b = next[next[b]];
        }
        a = start;
        while(a!=b){
            a = next[a];
            b= next[b];
        }
        ans[0] = a;
        b = next[a];
        int len = 1;
        while(a!=b){
            b = next[b];
            len++;
        }
        ans[1] = len;
        return ans;
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() { this(System.in, System.out); }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}