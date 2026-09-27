import java.io.*;
import java.util.StringTokenizer;

public class CBS {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        // Use long for the array elements since c_i can be up to 10^9
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kattio.nextLong();
        }

        long total_count = 0;
        for (int i = 0; i < N; i += 2) {
            long currbalance = 0;
            long minbalance = 0;
            for (int k = i + 1; k < N; k++) {

                if (k % 2 == 1) {
                    long minx = Math.max(1L, 1L - currbalance);
                    minx = Math.max(minx, -minbalance);


                    long maxx = Math.min(arr[i], arr[k] - currbalance);

                    if (minx <= maxx) {
                        total_count += (maxx - minx + 1);
                    }
                    currbalance -= arr[k];
                    minbalance = Math.min(minbalance, currbalance);

                } else {
                    currbalance += arr[k];
                    minbalance = Math.min(minbalance, currbalance);
                }
            }
        }

        kattio.println(total_count);
        kattio.close();
    }

    static long a(int i, long[] open, long[] closed) {
        if (i == 0) return 0;
        else if (i == 1) return open[0];
        else return open[(i - 1) / 2] - closed[(i - 2) / 2];
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
