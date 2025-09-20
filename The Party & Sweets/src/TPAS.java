import java.util.*;
import java.io.*;

public class TPAS {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int b = io.nextInt();
        int g = io.nextInt(); 
        long rm = 0;
        long rm2 = 0; 
        long rsum = 0; 
        for (int i = 0; i < b; i++) {
            long a = io.nextLong();
            if (rm <= a) {
                rm2 = rm;
                rm = a;
            } else if (rm2 <= a) {
                rm2 = a;
            }
            rsum += a;
        }
        long cmin = Long.MAX_VALUE;
        long csum = 0;

        for (int i = 0; i < g; i++) {
            long a = io.nextLong();
            if (cmin >= a) {
                cmin = a;
            }
            csum += a;
        }

        if (rm > cmin) {
            io.println(-1);
        } else {
            long ans = rsum * g;
            ans += csum;
            ans -= rm * g;
            if (rm < cmin) {
                ans += rm - rm2;
            }
            io.println(ans);
        }
        io.close();
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
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
