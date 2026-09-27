import java.io.*;
import java.util.StringTokenizer;

public class BSAF {
public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            String bin = kattio.next();
            long sum = 0;
            long len  =0;
            for (int i = 0; i < N; i++) {
                long count = 0;
                if (i == 0 || bin.charAt(i) != bin.charAt(i - 1)) {
                    // Start of a new block, P=1
                    len = 1;
                } else {
                    len++;
                }


               sum = (sum + power(2, len-1))%998244353;
            }
            kattio.println(sum);
        }
        kattio.close();
}
    public static long power(long base, long exp) {
        long res = 1;
        base %= 998244353;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % 998244353;
            }
            base = (base * base) % 998244353;
            exp /= 2;
        }
        return res;
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // Returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
