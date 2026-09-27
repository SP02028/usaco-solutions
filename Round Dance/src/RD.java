import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class RD {
    static boolean[] visited;
    static HashSet<Integer>[] adj;
    static List<List<Integer>> comps ;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while(t-->0){
            int N = io.nextInt();
            adj = new HashSet[N];
            visited = new boolean[N];
            comps = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj[i] = new HashSet<>();
            }
            for (int i = 0; i < N; i++) {
                int a = io.nextInt()-1;
                adj[i].add(a);
                adj[a].add(i);
            }
            int compcnt= 0;
            int closedCnt = 0;
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                if(!visited[i]){
                    dfs(i, temp);
                    comps.add(temp);
                    compcnt++;
                    boolean closed = true;
                    for (int node : temp) {
                        if (adj[node].size() < 2) {
                            closed = false;
                            break;
                        }
                    }
                    if (closed) closedCnt++;
                }
            }
            int min = compcnt;
            int max = compcnt;
            if (closedCnt == compcnt) {
                min = compcnt; // all closed
            } else {
                min = closedCnt + 1; // open components merge into one, closed stay separate
            }

            io.print(min + " " + max);
            io.println();
        }
        io.close();
    }
    public static void dfs(int s, ArrayList<Integer> res){
        if (visited[s]) {
            return;
        }
        res. add(s);
        visited[s] = true;
        for (int nbr : adj[s]) {
            dfs(nbr, res);
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
