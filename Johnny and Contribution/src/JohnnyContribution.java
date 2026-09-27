import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;



public class JohnnyContribution {

    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int m = io.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = io.nextInt();
            int v = io.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        int[][] nodes = new int[n][2];
        int[] T = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int topic = io.nextInt();
            T[i] = topic;
            nodes[i - 1][0] = topic;
            nodes[i - 1][1] = i;
        }

        Arrays.sort(nodes, Comparator.comparingInt(a -> a[0]));

        int[] visited = new int[n + 1];
        int id = 0;

        List<Integer> res = new ArrayList<>();

        for (int[] node : nodes) {
            int t1 = node[0];
            int u = node[1];

            id++;
            int cnt = 0;

            for (int v : adj[u]) {
                int t2 = T[v];
                if (t1 == t2) {
                    io.println(-1);
                    io.close();
                    return;
                }
                if (t2 < t1) {
                    if (visited[t2] != id) {
                        visited[t2] = id;
                        cnt++;
                    }
                }
            }
            if (cnt != t1 - 1) {
                io.println(-1);
                io.close();
                return;
            }

            res.add(u);
        }
        for (int i = 0; i < n; i++) {
            io.print(res.get(i));
            if (i < n - 1) {
                io.print(" ");
            }
        }
        io.println();
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(java.io.InputStream i, java.io.OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
    }
}