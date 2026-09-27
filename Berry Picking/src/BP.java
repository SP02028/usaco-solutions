import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BP {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int trees = kattio.nextInt();
        int maxtree = -1;
        int sum =0;
        int baskets = kattio.nextInt();
        int[] counts = new int[trees];
        for (int i = 0; i < trees; i++) {
            counts[i] = kattio.nextInt();
            maxtree = Math.max(maxtree, counts[i]);
        }

        int best = 0;
        for (int b = 1; b <= maxtree; b++) {
            int full = 0;
            for (int i = 0; i < trees; i++) {
                full += counts[i] / b;
            }

            if (full < baskets / 2) {
                break;
            }

            if (full >= baskets) {
                best = Math.max(best, b * (baskets / 2));
                continue;
            }
            Integer[] remainders = new Integer[trees];
            for (int i = 0; i < trees; i++) {
                remainders[i] = counts[i] % b;
            }
            Arrays.sort(remainders, Collections.reverseOrder());

            int cur = b * (full - baskets / 2);
            int need = baskets - full;
            for (int i = 0; i < need && i < trees; i++) {
                cur += remainders[i];
            }
            best = Math.max(best, cur);
        }

        kattio.println(best);
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
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            this.r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (this.st == null || !this.st.hasMoreTokens()) {
                    this.st = new StringTokenizer(this.r.readLine());
                }
                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public double nextDouble() {
            return Double.parseDouble(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
