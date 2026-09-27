import java.util.*;
import java.io.*;
public class RaS {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T =kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            int q =kattio.nextInt();
            int[] a = new int[N];
            int[] b=new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = kattio.nextInt();
            }
            for (int i = 0; i < N; i++) {
                b[i] = kattio.nextInt();
            }
            int[] res = new int[N];
            res[N-1] = Math.max(a[N-1], b[N-1]);
            for (int i = N-2; i >=0; i--) {
                res[i] = Math.max(Math.max(res[i+1],a[i]),Math.max(a[i], b[i]));
            }
            int[] pref = new int[N+1];
            pref[1] = res[0];
            for (int i = 1; i <=N ; i++) {
                pref[i] = pref[i-1] + res[i-1];
            }
            for (int i = 0; i < q; i++) {
                int l = kattio.nextInt();
                int r = kattio.nextInt();
                kattio.print(pref[r] - pref[l-1] + " ");
            }
            kattio.println();
        }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Input and output as System.in and System.out
        public Kattio() {
            this(System.in, System.out);
        }

        // Input and output streams
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // Read the next token
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        // Next integer
        public int nextInt() {
            return Integer.parseInt(next());
        }

        // Next long
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
