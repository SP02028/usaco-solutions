import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
public class B {
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        for (int i = 1; i <=N ; i++) {
            graph.computeIfAbsent(i, k-> new ArrayList<>()).add(kattio.nextInt());
        }

        for (int i = 1; i <=N; i++) {
            int a = graph.get(i).getFirst();
            int b  = graph.get(graph.get(i).getFirst()).getFirst();

            while(a!=b){
                 a = graph.get(a).getFirst();
                 b  = graph.get(graph.get(b).getFirst()).getFirst();
            }
            a=i;
            while(a!=b){
                a = graph.get(a).getFirst();
                b  = graph.get(b).getFirst();
            }
            int first = a;
            kattio.print(a +" ");
        }
kattio.close();
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
