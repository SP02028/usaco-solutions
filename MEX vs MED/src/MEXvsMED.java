import java.io.*;
import java.util.*;
public class MEXvsMED {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int testNum = io.nextInt();
        for (int t = 0; t < testNum; t++) {
            int n = io.nextInt();

            // stores position of integer
            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                int x = io.nextInt();
                pos[x] = i;
            }

            // initialize left and right bounds for mex
            int left = pos[0], right = pos[0];
            long res = 1;

            // mex represents the current mex left and right cover
            for (int mex = 1; mex < n; mex++) {
                int nextPos = pos[mex];

                // skip if next_pos is already between left and right
                if (left <= nextPos && nextPos <= right) { continue; }
                // Since we can create a valid subsegment for a given mex up until
                // size mex * 2, our max diff between left and right is mex * 2 - 1
                int maxDiff = mex * 2 - 1;

                if (nextPos < left) {
                    for (; left > nextPos; left--) {
                        int largest_right = Math.min(left + maxDiff, n - 1);
                        // add all possible right bounds that don't change the
                        // current mex
                        res += Math.max(largest_right - right + 1, 0);
                    }
                } else {
                    for (; right < nextPos; right++) {
                        int smallest_left = Math.max(right - maxDiff, 0);
                        // add all possible left bounds that don't change the
                        // current mex
                        res += Math.max(left - smallest_left + 1, 0);
                    }
                }
            }

            io.println(res);
        }

        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
    //EndCodeSnip
}