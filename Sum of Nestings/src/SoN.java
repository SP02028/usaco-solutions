import java.util.*;
import java.io.*;
public class SoN {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        long N = kattio.nextLong();
        long K = kattio.nextLong();
        int[] arr = new int[(int) N];
        if(N*(N-1)/2 <K){
            kattio.println("Impossible");
           kattio.close();
        }
        long curr =0;
        long maxnest = 0;
        for (int i = 1; i <= N; i++) {
            long next = curr + (i-1);
            if(next<=K){
                curr = next;
                maxnest= i;
            }else{
                break;
            }
        }
        long total = K-curr;
        long V =N-maxnest;
        if (V == 0) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < maxnest; i++) {
                res.append('(');
            }
            for (int i = 0; i < maxnest; i++) {
                res.append(')');
            }
            kattio.println(res.toString());
            kattio.close();
            return;
        }

        long D = total/V;
        long R = total%V;
        long hi = R;
        long lo = V-R;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < D; i++) {
            res.append('(');
        }
        for (int i = 0; i < lo; i++) {
            res.append("()");
        }
        res.append('(');
        for (int i = 0; i < hi; i++) {
            res.append("()");
        }
        for (int i = 0; i < maxnest-D-1; i++) {
            res.append('(');
        }
        for (int i = 0; i < maxnest; i++) {
            res.append(')');
        }
        kattio.println(res.toString());
        kattio.close();
    }
    static class Kattio extends
            PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
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
        public long nextLong() { return Long.parseLong(next()); }
    }
}
