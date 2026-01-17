import java.util.*;
import java.io.*;

public class RectangularPasture {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        long[] xs = new long[N];
        long[] ys = new long[N];
        long[] ogx = new long[N];
        long[] ogy = new long[N];

        Map<Long, Integer> xotn = new HashMap<>();
        Map<Long, Integer> yotn = new HashMap<>();

        for (int i = 0; i < N; i++) {
            ogx[i] = io.nextLong();
            ogy[i] = io.nextLong();
            xs[i] = ogx[i];
            ys[i] = ogy[i];
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        for (int i = 0; i < N; i++) {
            xotn.put(xs[i], i + 1);
            yotn.put(ys[i], i + 1);
        }

        int[][] pfx = new int[N + 1][N + 1];
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            arr[xotn.get(ogx[i])][yotn.get(ogy[i])] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pfx[i][j] = arr[i][j] + pfx[i - 1][j] + pfx[i][j - 1] - pfx[i - 1][j - 1];
            }
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int x1 = Math.min(xotn.get(ogx[i]), xotn.get(ogx[j]));
                int x2 = Math.max(xotn.get(ogx[i]), xotn.get(ogx[j]));
                int y1 = Math.min(yotn.get(ogy[i]), yotn.get(ogy[j]));
                int y2 = Math.max(yotn.get(ogy[i]), yotn.get(ogy[j]));
                long sum1 = sum(pfx, x1, 1, x2, y1);
                long sum2 = sum(pfx, x1, y2, x2, N);

                ans += sum1 * sum2;
            }
        }

        io.println(ans + 1);
        io.close();
    }

    public static int sum(int[][] pfx, int x1, int y1, int x2, int y2) {
        return pfx[x2][y2] - pfx[x1 - 1][y2] - pfx[x2][y1 - 1] + pfx[x1 - 1][y1 - 1];
    }

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
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
