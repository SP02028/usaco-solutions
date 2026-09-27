import java.io.*;
import java.util.*;

public class MFII {

    public static void main(String[] args) throws IOException {
       Kattio kattio = new Kattio();
        int n = kattio.nextInt();
        int k = kattio.nextInt();
        long[][] movies = new long[n][2];
        for (int i = 0; i < n; i++) {
            movies[i][0] = kattio.nextLong();
            movies[i][1] = kattio.nextLong();
        }
        Arrays.sort(movies, (a, b) -> Long.compare(a[1], b[1]));
        // TreeMap as a multiset to store the finishing times of the K members
        // Key: finishing time, Value: frequency
        TreeMap<Long, Long> ends = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            ends.put(0L, ends.getOrDefault(0L, 0L) + 1);
        }
        int count = 0;

        for (long[] movie : movies) {
            long start = movie[0];
            long end = movie[1];
            Long time = ends.floorKey(start);

            if (time != null) {
                count++;
                long c = ends.get(time);
                if (c == 1) {
                    ends.remove(time);
                } else {
                    ends.put(time, c - 1);
                }

                ends.put(end, ends.getOrDefault(end, 0L) + 1);
            }
        }

        kattio.println(count);
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
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
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
