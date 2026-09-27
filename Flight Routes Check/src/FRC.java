import java.io.*;
import java.util.*;
public class FRC {
    static List<Integer>[] og;
    static List<Integer>[] rev;
    static boolean[] visited;

    public static void main(String[] args){
        Kattio io = new Kattio();
        int n = io.nextInt();
        int e = io.nextInt();
        og = new ArrayList[n];
        rev = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            og[i] = new ArrayList<Integer>();
            rev[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < e; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            og[a].add(b);
            rev[b].add(a);
        }

        dfs(0, og);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                io.println("NO");
                io.println(1 + " " + (i + 1)); // 1-based
                io.close();
                return;
            }
        }

        Arrays.fill(visited, false);
        dfs(0, rev);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                io.println("NO");
                io.println((i + 1) + " " + 1); // 1-based
                io.close();
                return;
            }
        }

        io.println("YES");
        io.close();
    }

    static void dfs(int s, List<Integer>[] graph){
        if (visited[s]) return;
        visited[s] = true;
        for (int nbr : graph[s]) {
            if (!visited[nbr]) dfs(nbr, graph);
        }
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
