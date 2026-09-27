import java.io.*;
import java.util.*;

public class SumOfSubstrings {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int t = kattio.nextInt();

        while (t-- > 0) {
            int N = kattio.nextInt();
            int K = kattio.nextInt();
            String string = kattio.next();

            int ones = 0;
            int first1 = N;
            int last1 = -1;

            for (int i = 0; i < N; i++) {
                if (string.charAt(i) == '1') {
                    ones++;
                    first1 = Math.min(first1, i);
                    last1 = Math.max(last1, i);
                }
            }

            int add = 0;

            // Move last '1' to end (worth +1)
            if (ones > 0 && (N - 1 - last1) <= K) {
                K -= (N - 1 - last1);
                add += 1;
                ones--;
            }

            // Move first '1' to start (worth +10)
            if (ones > 0 && first1 <= K) {
                K -= first1;
                add += 10;
                ones--;
            }

            int ans = 11 * ones + add;
            kattio.println(ans);
        }

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
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
