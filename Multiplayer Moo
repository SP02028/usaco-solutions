import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MuM3 {

    static int N;
    static int[][] grid;

    static final int MAX_A = 1_000_000;
    static final int[] DR = {1, 0, -1, 0};
    static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        Kattio kattio = new Kattio("multimoo");

        N = kattio.nextInt();
        grid = new int[N][N];

        int[] total = new int[MAX_A + 1];   // total cells of each value (like total[] in C++)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = kattio.nextInt();
                grid[i][j] = v;
                if (0 <= v && v <= MAX_A) total[v]++;
            }
        }

        // ---------------------------
        // One Cow (ans1)
        // ---------------------------
        boolean[][] seen = new boolean[N][N];
        int[] maxComp = new int[MAX_A + 1]; // max component size per value (like maxComp[] in C++)
        int ans1 = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (seen[r][c]) continue;

                int color = grid[r][c];
                int cnt = 0;

                seen[r][c] = true;
                q.addLast(new int[]{r, c});

                while (!q.isEmpty()) {
                    int[] cur = q.removeFirst();
                    int cr = cur[0], cc = cur[1];
                    cnt++;

                    for (int k = 0; k < 4; k++) {
                        int nr = cr + DR[k];
                        int nc = cc + DC[k];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if (seen[nr][nc]) continue;
                        if (grid[nr][nc] != color) continue;

                        seen[nr][nc] = true;
                        q.addLast(new int[]{nr, nc});
                    }
                }

                if (0 <= color && color <= MAX_A) {
                    if (cnt > maxComp[color]) maxComp[color] = cnt;
                }
                if (cnt > ans1) ans1 = cnt;
            }
        }

        kattio.println(ans1);

        // Collect values that appear at least once (like vals vector in C++)
        ArrayList<Integer> vals = new ArrayList<>();
        for (int v = 0; v <= MAX_A; v++) {
            if (total[v] > 0) vals.add(v);
        }

        // sort(vals) by total desc (like cmp in C++)
        Collections.sort(vals, (a, b) -> Integer.compare(total[b], total[a]));

        // ---------------------------
        // Two Cows (ans2)
        // Implements the C++ idea:
        // - consider pairs of values, pruned by (total[v1] + total[v2] <= ans2)
        // - for each pair, BFS over grid cells restricted to {v1, v2}
        // ---------------------------
        int ans2 = ans1;
        int m = vals.size();

        boolean[][] seen2 = new boolean[N][N];
        ArrayDeque<int[]> q2 = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            int t1 = vals.get(i);

            // Since totals are sorted descending, once total[t1] + total[t2] <= ans2,
            // all later t2 will only be smaller, so we can break.
            for (int j = i + 1; j < m; j++) {
                int t2 = vals.get(j);
                if (total[t1] + total[t2] <= ans2) break;

                // clear seen2
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        seen2[r][c] = false;
                    }
                }

                int bestPair = 0;

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        int v = grid[r][c];
                        if (v != t1 && v != t2) continue;
                        if (seen2[r][c]) continue;

                        int cnt = 0;
                        seen2[r][c] = true;
                        q2.addLast(new int[]{r, c});

                        while (!q2.isEmpty()) {
                            int[] cur = q2.removeFirst();
                            int cr = cur[0], cc = cur[1];
                            cnt++;

                            for (int k = 0; k < 4; k++) {
                                int nr = cr + DR[k];
                                int nc = cc + DC[k];
                                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                                if (seen2[nr][nc]) continue;
                                int nv = grid[nr][nc];
                                if (nv != t1 && nv != t2) continue;

                                seen2[nr][nc] = true;
                                q2.addLast(new int[]{nr, nc});
                            }
                        }

                        if (cnt > bestPair) bestPair = cnt;
                        if (bestPair > ans2) ans2 = bestPair;
                    }
                }
            }
        }

        kattio.println(ans2);
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
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
