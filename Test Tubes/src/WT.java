import java.io.PrintWriter;
import java.io.*;
import java.util.*;
public class WT {

    private static boolean[] visited;
    private static List<List<Integer>> adj;
    private static List<int[]> ans;

    private static boolean dfs(int x, int pre) {
        visited[x] = true;
        List<Integer> curr = new ArrayList<>();
        for (int i : adj.get(x)) {
            if (i != pre) { //don't go back up to the parent
                if (visited[i]) {  // non spanning tree edge
                    if (x < i) { curr.add(i); } //only add edge once
                } else if (dfs(i, x)) {
                    curr.add(i);  // spanning tree edge
                }
            }
        }

        for (int i = 0; i < curr.size() / 2; i++) {
            ans.add(new int[] {curr.get(2 * i), x, curr.get(2 * i + 1)}); //pairing up consec edges?
        }
        if (curr.size() % 2 == 0) { return true; }
        if (pre != -1) { ans.add(new int[] {curr.get(curr.size() - 1), x, pre}); } //theres a path from last node thats not paired, to x, to parent
        //this only happens if odd num edges in the subtree

        return false;
    }

    public static void main(String[] args) throws IOException {
        Kattio kattio =new Kattio();
        int n = kattio.nextInt();

        int m = kattio.nextInt();

        visited = new boolean[n + 1];
        adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) { adj.add(new ArrayList<>()); }
        ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a =kattio .nextInt();
            int b = kattio.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a); //construct graph
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { dfs(i, -1); }//pairs up edges by running dfs
        }

       kattio.println(ans.size());
        for (int[] a : ans) { kattio.println(a[0] + " " + a[1] + " " + a[2]); }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

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
                while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
