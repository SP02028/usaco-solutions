import java.util.*;
import java.io.*;

public class UP {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int t = kattio.nextInt();
        while (t-- > 0) {
            int n = kattio.nextInt();
            int k = kattio.nextInt();

            int[] x = new int[k];
            for (int i = 0; i < k; i++) {
                x[i] = kattio.nextInt();
            }

            long[] c = new long[k];
            for (int i = 0; i < k; i++) {
                c[i] = kattio.nextLong();
            }

            if (c[0] < 3 || c[0] > x[0]) {
                kattio.println("NO");
                continue;
            }

            StringBuilder s = new StringBuilder();
            char cur = 'a';

            for (int i = 0; i < (int) (c[0] - 3); i++) {
                s.append('a');
            }
            for (int i = (int) (c[0] - 3); i < x[0]; i++) {
                s.append(cur);
                cur = nextCur(cur);
            }

            boolean good = true;
            for (int j = 1; j < k; j++) {
                int dx = x[j] - x[j - 1];
                long dc = c[j] - c[j - 1];
                if (dc < 0 || dc > dx) {
                    good = false;
                    break;
                }

                char forced = (char) ('c' + j);
                for (int i = 0; i < (int) dc; i++) s.append(forced);

                for (int i = (int) dc; i < dx; i++) {
                    s.append(cur);
                    cur = nextCur(cur);
                }
            }

            if (good) {
                kattio.println("YES");
                kattio.println(s.toString());
            } else {
                kattio.println("NO");
            }
        }
        kattio.flush(); // make sure output is written even if something goes wrong later
        kattio.close();
    }

    private static char nextCur(char cur) {
        cur = (char) (cur + 1);
        if (cur == 'd') cur = 'a';
        return cur;
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

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) {
                        throw new NoSuchElementException("Unexpected EOF while reading input");
                    }
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
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
