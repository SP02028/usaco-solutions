import java.util.*;
import java.io.*;
public class V {
    static long[][] next;
    static boolean[] visited;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        next = new long[N+1][2];
        visited= new boolean[N+1];
        long total = 0;
        for (int i = 1; i <= N; i++) {
            next[i][0] = kattio.nextLong();
            next[i][1] = kattio.nextLong();
            total += next[i][1];
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                total -= floyd(i);
            }
        }
    kattio.println(total);
        kattio.close();
    }
    static long floyd(int curr) {
        long minweight = Long.MAX_VALUE;
        int a = (int) next[curr][0];
        int b = (int) next[(int) next[curr][0]][0];
        while (a != b && !visited[a] && !visited[b]) {
            a = (int) next[a][0];
            b = (int) next[(int) next[b][0]][0];
        }
        if (visited[a] || visited[b]) return 0;
        a = curr;
        while (a != b) {
            a = (int) next[a][0];
            b = (int) next[b][0];
        }
        int startNode = a;
        visited[a] = true;
        minweight = Math.min(minweight, next[a][1]);
        b = (int) next[a][0];

        while (b != startNode) {
            visited[b] = true;
            minweight = Math.min(minweight, next[b][1]);
            b = (int) next[b][0];
        }

        return minweight;
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
