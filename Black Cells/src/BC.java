import java.io.*;
import java.util.*;
public class BC {
    public static void main(String[] args) {
       Kattio io =new Kattio();
        int t = io.nextInt();
        while (t-- > 0) {
            int n = io.nextInt(), k = io.nextInt();
            int[] l = new int[n], r = new int[n];
            for (int i = 0; i < n; i++) {
                l[i] = io.nextInt();
            }
            for (int i = 0; i < n; i++) {
                r[i] = io.nextInt();
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += r[i] - l[i] + 1;
            }
            if (sum < k) {
                io.println(-1);
                continue;
            }
            int curr = 0, one = 0;
            int op = 0;
            int ans = (int) 2e9;
            for (int i = 0; i < n; i++) {
                int len = r[i] - l[i] + 1;
                if (len == 1) one++;
                else {
                    curr += len;
                    op++;

                }
                if (curr >= k) {
                    int delta = curr - k;
                    int v = op * 2 + r[i] - delta;
                    ans = Math.min(ans, v);
                } else if (curr + one >= k) {
                    int need = k - curr;
                    int v = (op + need) * 2 + r[i];
                    ans = Math.min(ans, v);
                }
            }
            io.println(ans);
        }
       io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public long nextLong() {
            // TODO Auto-generated method stub
            return Long.parseLong(next())	;	}
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}
