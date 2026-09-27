import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays; // Need Arrays for sorting

public class RaP {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while (T-- > 0) {
            int n = kattio.nextInt();
            int k = kattio.nextInt();

            long[] a = new long[n];
            long[] sorted = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = kattio.nextLong();
                sorted[i] = a[i];
            }

            Arrays.sort(sorted);
            int req = (n + k + 1) / 2;
            long mindiff = n;
            long l = -1;
            long r = -1;
            // Iterate over all windows of size req in the sorted array
            for (int i = 0; i <= n -req; i++) {
                long currl = sorted[i];
                long currr = sorted[i + req - 1];

                if (currr - currl < mindiff) {
                    mindiff = currr - currl;
                    l = currl;
                    r = currr;
                }
            }

            kattio.println(l + " " + r);
            int cuts = k - 1;
            int start = 0;
            int balance = 0;
            for (int i = 0; i < n; i++) {
                // Score: +1 if in [l, r], -1 otherwise
                if (a[i] >= l && a[i] <= r) {
                    balance++;
                } else {
                    balance--;
                }
                if (cuts > 0 && balance > 0) {
                    kattio.println((start + 1) + " " + (i + 1));
                    cuts--;
                    start = i + 1;
                    balance = 0;
                }
            }
            kattio.println((start + 1) + " " + n);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        @Override
        public void close() {
            super.close();
            try {
                r.close();
            } catch (IOException ignored) {
            }
        }
    }
}
