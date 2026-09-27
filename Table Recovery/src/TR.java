import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TR {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();

        int[][] grid = new int[N][N];
        int[] freq = new int[2 * N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = kattio.nextInt();
                freq[grid[i][j]]++;
            }
        }

        if (N == 1) {
            kattio.println(grid[0][0]);
            kattio.flush();
            return;
        }
        // Find the two cells whose values have frequency 1
        int rA = -1, cA = -1, rB = -1, cB = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (freq[grid[i][j]] == 1) {
                    if (rA == -1) {
                        rA = i;
                        cA = j;
                    } else {
                        rB = i;
                        cB = j;
                    }
                }
            }
        }

        int[][] ans1 = buildCandidate(grid, freq, N, rA, cA);
        int[][] ans2 = buildCandidate(grid, freq, N, rB, cB);

        int[][] best;
        if (ans1 == null) best = ans2;
        else if (ans2 == null) best = ans1;
        else best = lexicographicallyMin(ans1, ans2, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0) kattio.print(' ');
                kattio.print(best[i][j]);
            }
            kattio.println();
        }
        kattio.flush();
    }

    private static int[][] buildCandidate(int[][] grid, int[] freq, int N, int r1, int c1) {
        if (r1 < 0 || c1 < 0) return null;

        int[] P = new int[N];
        int[] Q = new int[N];

        // P[i] = freq[ value at (i, c1) ]
        for (int i = 0; i < N; i++) {
            int v = grid[i][c1];
            P[i] = freq[v];
        }

        // Q[j] = freq[ value at (r1, j) ]
        for (int j = 0; j < N; j++) {
            int v = grid[r1][j];
            Q[j] = freq[v];
        }

        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            int pi = P[i];
            for (int j = 0; j < N; j++) {
                ans[i][j] = pi + Q[j];
            }
        }
        return ans;
    }

    private static int[][] lexicographicallyMin(int[][] A, int[][] B, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] < B[i][j]) return A;
                if (A[i][j] > B[i][j]) return B;
            }
        }
        return A;
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
