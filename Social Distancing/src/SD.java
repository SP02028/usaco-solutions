import java.io.*;
import java.util.*;

public class SD {
    static TreeMap<Long, Long> map = new TreeMap<Long, Long>();

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();
        long[][] intervals = new long[M][2];
        long max = -1;
        for (int i = 0; i < M; i++) {
            long a = kattio.nextLong();
            long b = kattio.nextLong();
            intervals[i][0] = a;
            intervals[i][1] = b;
            if (b > max) max = b;
        }
        Arrays.sort(intervals, new Comparator<long[]>() {
            @Override
            public int compare(long[] arr1, long[] arr2) {
                return Long.compare(arr1[0], arr2[0]);
            }
        });
        long lo = 1;
        long hi = max;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (ispos(mid, N, intervals)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        kattio.println(hi);
        kattio.close();
    }
    static boolean ispos(long D, int N, long[][] intervals) {
        long placed = 1;
        long lastpos = intervals[0][0];
        for (long[] interval : intervals) {
            long start = interval[0];
            long end = interval[1];
            if (end < lastpos + D) continue;
            lastpos = Math.max(lastpos+D, start);
            placed++;
            while (lastpos + D <= end) {
                lastpos += D;
                placed++;
                if (placed >= N) return true;
            }
        }
        return placed >= N;
    }

    static boolean ispos(long D, int N) {
        long placed = 1;
        long lastpos = map.firstKey();

        for (long start : map.keySet()) {
            long end = map.get(start);

            lastpos = Math.max(lastpos, start);

            while (lastpos + D <= end) {
                lastpos += D;
                placed++;
                if (placed >= N) return true;
            }
        }

        return placed >= N;
    }

    // Kattio class remains unchanged
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
    }
}
