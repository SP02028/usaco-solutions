import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T =kattio.nextInt();
        while(T-->0){
            long N = kattio.nextLong();
            int M = kattio.nextInt();
            long K = kattio.nextLong();
            long[] colors = new long[M];
            long max = Math.ceilDiv(N, K);
            long available_bigger = N%K; //number of sets that can have floor(n/k)+1
            long size = (N/K)+1;
            boolean possible = true;
            for (int i = 0; i < M; i++) {
                colors[i] = kattio.nextLong();
                if(colors[i] > max){
                    possible = false;
                }
                if(colors[i] ==size){
                    available_bigger--;
                }
            }
            if(available_bigger <0){
                possible = false;
            }
            if(!possible){
                kattio.println("NO");
            }else{
                kattio.println("YES");
            }
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
