import java.io.*;
import java.util.*;

public class HPYB {

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int x = io.nextInt();
        int M = 200001; // Max coordinate + 1
        long I = 4_000_000_000L; // Infinity cost
        List<long[]> e = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = io.nextInt();
            int r = io.nextInt();
            long c = io.nextLong();
            int d = r - l + 1;
            // [Time, Type, Duration, Cost]
            // Type: -1 (Start), 1 (End)
            e.add(new long[]{(long)l, -1L, (long)d, c});
            e.add(new long[]{(long)r, 1L, (long)d, c});
        }

        Comparator<long[]> cmp = new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b) {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            }
        };

        Collections.sort(e, cmp);

        long[] bc = new long[M];
        Arrays.fill(bc, I);

        long ans = I;

        for (long[] event : e) {
            int t = (int) event[1];
            int d = (int) event[2];
            long c = event[3];

            if (t == -1) {
                int dr = x - d;
                if (dr > 0 && dr < M) {
                    long pc = bc[dr];
                    if (pc != I) {
                        ans = Math.min(ans, c + pc);
                    }
                }
            } else {
                bc[d] = Math.min(bc[d], c);
            }
        }

        if (ans >= I) {
            io.println(-1);
        } else {
            io.println(ans);
        }

        io.flush();
    }

    // Kattio class remains static as it relies on System streams
    static class Kattio extends PrintWriter {
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
            } catch (Exception e) { return null; }
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
