import java.util.*;
import java.io.*;

public class CL {

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int G = io.nextInt();
        int C = io.nextInt();
        List<long[]> grazings = new ArrayList<>();

        // Read grazing events
        for (int i = 0; i < G; i++) {
            long x = io.nextLong();
            long y = io.nextLong();
            long t = io.nextLong();
            grazings.add(new long[]{t, x, y});
        }

        Comparator<long[]> cmp = Comparator
                .comparingLong((long[] a) -> a[0])
                .thenComparingLong(a -> a[1])
                .thenComparingLong(a -> a[2]);

        grazings.sort(cmp);

        int ans = 0;
        for (int i = 0; i < C; i++) {
            long x = io.nextLong();
            long y = io.nextLong();
            long t = io.nextLong();
            long[] alibi = new long[]{t, x, y};

            int pos = Collections.binarySearch(grazings, alibi, cmp);
            if (pos < 0) {
                pos = -(pos + 1);
            } else {
                pos = pos + 1; // match Python's bisect() behavior
            }

            boolean innocent = false;
            for (int n : new int[]{pos - 1, pos}) {
                if (n >= 0 && n < G) {
                    long dx = grazings.get(n)[1] - alibi[1];
                    long dy = grazings.get(n)[2] - alibi[2];
                    long dt = grazings.get(n)[0] - alibi[0];
                    long distSq = dx * dx + dy * dy;
                    long timeSq = dt * dt;
                    boolean canReach = distSq <= timeSq;
                    if (!canReach) {
                        innocent = true;
                    }
                }
            }

            if (innocent) {
                ans++;
            }
        }

        io.println(ans);
        io.close();
    }

    // Fast IO helper
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

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}

