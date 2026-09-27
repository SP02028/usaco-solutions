import java.io.*;
import java.util.*;

public class ST1 {

    static final int N = 20;
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static void dfs(int u) {
        vis[u] = true;
        for (int v : adj[u]) {
            if (!vis[v]) dfs(v);
        }
    }
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while (t-- > 0) {
            int n = io.nextInt();
            String a = io.next();
            String b = io.next();
            boolean bad = false;
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    int x = a.charAt(i) - 'a';
                    int y = b.charAt(i) - 'a';
                    if (x > y) {
                        io.println(-1);
                        bad = true;
                        break;
                    }
                    adj[x].add(y);
                    adj[y].add(x);
                }
            }
            if (bad) continue;
            vis = new boolean[N];
            int ans = N;
            for (int i = 0; i < N; i++) {
                if (!vis[i]) {
                    dfs(i);
                    ans--;
                }
            }
            io.println(ans);
        }
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        Kattio() {
            super(new BufferedWriter(new OutputStreamWriter(System.out)));
            r = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = r.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
