import java.io.*;
import java.util.StringTokenizer;

public class CCS {
    static int N, M;
    static int startI, startJ;
    static int[][] course;
    static boolean[][] waypoints;
    static boolean[][] visited;

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        N = kattio.nextInt();
        M = kattio.nextInt();

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        course = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                course[i][j] = kattio.nextInt();
                minHeight = Math.min(minHeight, course[i][j]);
                maxHeight = Math.max(maxHeight, course[i][j]);
            }
        }

        waypoints = new boolean[N][M];
        boolean foundStart = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int ans = kattio.nextInt();
                if (ans == 1) {
                    waypoints[i][j] = true;
                    if (!foundStart) {
                        startI = i;
                        startJ = j;
                        foundStart = true;
                    }
                }
            }
        }

        int lo = 0;
        int hi = maxHeight - minHeight;

        while (lo < hi) {
            int d = (lo + hi) / 2;
            if (reachable(d)) {
                hi = d;
            } else {
                lo = d + 1;
            }
        }

        kattio.println(lo);
        kattio.close();
    }

    static void floodfill(int i, int j, int d, int prevHeight) {
        if (i < 0 || i >= N || j < 0 || j >= M) return;
        if (visited[i][j]) return;
        if (Math.abs(course[i][j] - prevHeight) > d) return;

        visited[i][j] = true;

        floodfill(i + 1, j, d, course[i][j]);
        floodfill(i - 1, j, d, course[i][j]);
        floodfill(i, j - 1, d, course[i][j]);
        floodfill(i, j + 1, d, course[i][j]);
    }

    static boolean reachable(int d) {
        visited = new boolean[N][M];
        floodfill(startI, startJ, d, course[startI][startJ]);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (waypoints[i][j] && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
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
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
