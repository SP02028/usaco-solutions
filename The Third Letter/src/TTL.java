import java.io.*;
import java.util.*;
public class TTL {
    static boolean success = true;
   public static void main(String[] args) {
       Kattio kattio = new Kattio();
        int t = kattio.nextInt();
        while(t-- > 0) {
            int m = kattio.nextInt();
            int queries = kattio.nextInt();
            Map<Integer, List<int[]>> graph = new HashMap<>();
            long []distance = new long[m + 1];
            Set<Integer> visited = new HashSet<>();
            success = true;
            while(queries-- > 0) {
                int a = kattio.nextInt();
                int b = kattio.nextInt();
                int d = kattio.nextInt();
                if(!graph.containsKey(a)) {
                    graph.put(a, new ArrayList<>());
                }
                if(!graph.containsKey(b)) {
                    graph.put(b, new ArrayList<>());
                }
                graph.get(a).add(new int[]{b, d});
                graph.get(b).add(new int[]{a, -d});
            }
            Arrays.fill(distance, 0L);

            for(int i=1; i<=m; i++) {
                if(!visited.contains(i)) {
                    dfs(i, graph, distance, visited);
                }
            }
            kattio.println((success) ? "YES": "NO");
        }
        kattio.close();
    }
    static void dfs(int current, Map<Integer, List<int[]>> graph, long []distance, Set<Integer> visited) {
        visited.add(current);

        if(graph.containsKey(current)) {
            for(int []children : graph.get(current)) {
                if(visited.contains(children[0])) {
                    if (distance[children[0]] != distance[current] + children[1]) {
                        success = false;
                    }
                }
                else {
                    distance[children[0]] = distance[current] + children[1];
                    dfs(children[0], graph, distance, visited);
                }
            }
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
        public long nextLong() { return Long.parseLong(next()); }
    }
}
