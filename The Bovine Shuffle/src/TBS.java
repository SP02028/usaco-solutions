import java.util.*;
import java.io.*;
public class TBS {
   static HashMap<Integer, Integer> adj = new HashMap<>();
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        for (int i = 0; i <N ; i++) {
            adj.put(i, kattio.nextInt()-1);
        }
        kattio.println(nodesincycle(N));
        kattio.close();
    }
    static int nodesincycle(int N){
        boolean[] incycle = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(incycle[i]) continue;

            boolean[] visited = new boolean[N];
            int curr = i;
            while(!visited[curr]){
                visited[curr] = true;
                curr = adj.get(curr);
            }

            int start = curr;
            incycle[curr] = true;
            curr= adj.get(curr);
            while(curr!=start){
                incycle[curr] = true;
                curr= adj.get(curr);
            }
        }
        int count =0;
        for(boolean b : incycle){
            if(b) count++;
        }
        return count;
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
