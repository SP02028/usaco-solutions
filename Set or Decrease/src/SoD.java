import java.io.*;
import java.util.*;
public class SoD {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            long k = kattio.nextLong();
            long[] arr = new long[N+1];
            for (int i = 1; i <=N ; i++) {
                arr[i] = kattio.nextLong();
            }
            Arrays.sort(arr);
            long[] pref = new long[N+1];
            for (int i = 1; i <=N ; i++) {
                pref[i] = pref[i-1]+ arr[i];
            }
            long ans = Long.MAX_VALUE;
            if(pref[N]<=k){
                kattio.println(0);
                continue;
            }
            for (int i = 0;i <N ; i++) {
                long prefix = pref[N-i]-arr[1];
                long rem = k - prefix;
                long max = Math.floorDiv(rem,(i+1));
                ans = Math.min(ans, Math.max(0,arr[1]-max)+i);
            }
            kattio.println(ans);
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
