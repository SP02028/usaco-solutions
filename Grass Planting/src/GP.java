import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class GP {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap(N);
        for (int i = 1; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            int a =kattio.nextInt();
            int b = kattio.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int max = 0;
        for(Integer k : adj.keySet()){
            max = Math.max(adj.get(k).size(), max);
        }
        kattio.println(max+1);
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
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while(this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }

                    this.st = new StringTokenizer(line);
                }

                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
