import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        long X = kattio.nextLong();
        long Y = kattio.nextLong();
        long Z = kattio.nextLong();
        long[] start = new long[N];
        long[] end = new long[N];
        for (int i = 0; i < N; i++) {
            start[i] = kattio.nextLong();
            end[i] = kattio.nextLong();
        }
        Arrays.sort(start);
        Arrays.sort(end);
        long best = X * N;
        for (int i = 0; i < N; i++) {
            best = Math.max(best, growth(start[i], start, end, X, Y, Z));
            best = Math.max(best, growth(end[i] + 1, start, end, X, Y, Z));
        }

        kattio.println(best);
        kattio.close();
    }

    // Total growth if the water level is T
    static long growth(long T, long[] start, long[] end, long X, long Y, long Z) {
        int n = start.length;
        long dry = n - upperBound(start, T);   // A > T
        long drowned = lowerBound(end, T);     // B < T
        long good = n - dry - drowned;
        return dry * X + good * Y + drowned * Z;
    }

    // First index with arr[idx] >= key
    static int lowerBound(long[] arr, long key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // First index with arr[idx] > key
    static int upperBound(long[] arr, long key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
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