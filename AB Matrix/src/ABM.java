import java.io.*;
import java.util.StringTokenizer;

public class ABM {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int t = kattio.nextInt();

        while (t-- > 0) {
            int N = kattio.nextInt();
            int M = kattio.nextInt();
            int A = kattio.nextInt();
            int B = kattio.nextInt();

            if (A * N != B * M) {
                kattio.println("NO");
                continue;
            }

            kattio.println("YES");

            // Construct matrix
            int[][] ans = new int[N][M];

            int shift = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < A; j++) {
                    ans[i][(shift + j) % M] = 1;
                }
                shift = (shift + A) % M;
            }

            // Output matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    kattio.print(ans[i][j]);
                }
                kattio.println();
            }
        }
        kattio.flush();
    }

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
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
