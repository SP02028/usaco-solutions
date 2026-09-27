import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DHV {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int t = kattio.nextInt();
        while(t-- > 0){
            int n = kattio.nextInt();
            long m = kattio.nextLong();
            long[] a = new long[n - 1];
            for (int i = 0; i < n - 1; i++) {
                a[i] = kattio.nextLong();
            }
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = kattio.nextLong();
            }
            Arrays.sort(b);

            // min ops when first element is 1
            long base = ops(1, a, b, n);
            //bc ai is nondecreasing and num ops must be an integer, the minops can only increase by 1
            //until a certain value, all values = base
            // the values after that are = base+1
            //we find the max value at which value = base via binary search
            long l = 1;
            long r = m;
            long max  = 0;

            while (l <= r) {
                long mid = l + (r - l) / 2;
                long currops = ops(mid, a, b, n);
                if (currops == base) {
                    max = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            long countless = max;
            long countmore= m - max;

            long ans = base * countless + (base + 1) * countmore;

            kattio.println(ans);
        }
        kattio.close();
    }

    private static long ops(long val, long[] a, long[] b, int n) {
        long[] c = new long[n];
        c[0] = val;
        System.arraycopy(a, 0, c, 1, n - 1);
        Arrays.sort(c);
        // Inner binary search for max pairs
        int lo = 0;
        int hi = n;
        int max = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean possible = true;
            for (int i = 0; i < mid; i++) {
                if (c[i] >= b[n - mid + i]) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                max = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return n - max;
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
