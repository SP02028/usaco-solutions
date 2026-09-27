import java.io.*;
import java.util.*;

public class TTiGH {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();
        List<Long> vertical  = new ArrayList<>();
        List<Long> horizontal  = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            vertical.add(kattio.nextLong());
        }
        for (int i = 0; i < M; i++) {
            long a = kattio.nextLong();
            long b = kattio.nextLong();
            long c = kattio.nextLong();
            if(a == 1){
                horizontal.add(b);
            }
        }
        Collections.sort(vertical);
        Collections.sort(horizontal);
        vertical.add(1000000000L);
        int j = 0;
        long mincost = Long.MAX_VALUE;
        for (int i = 0; i < vertical.size(); i++) {
            long cut = vertical.get(i);
            int removedv = i;
            while(j<horizontal.size() && horizontal.get(j)<cut  ){
                j++;
            }
            int removedh = horizontal.size()-j;
            mincost = Math.min(mincost, removedh+removedv);
        }
        kattio.println(mincost);
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
