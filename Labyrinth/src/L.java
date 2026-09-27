import java.io.*;
import java.util.*;

public class L {
    static final int MAX_SIZE = 2005;
    static int[][] maze = new int[MAX_SIZE][MAX_SIZE];
    // dist[r][c] stores the minimum number of LEFT moves (L_min) required to reach (r, c).
    static int[][] dist = new int[MAX_SIZE][MAX_SIZE];
    static int N, M;
    static int startR, startC;
    static long maxL, maxR; // Max allowed Left (X) and Right (Y) moves
    static final int[] DR = {0, -1, 1, 0, 0};
    static final int[] DC = {0, 0, 0, 1, -1};
    // Indices: 1=Up, 2=Down, 3=Right, 4=Left
    public static void main(String[] args) {
        Kattio io = new Kattio();
        N = io.nextInt();
        M = io.nextInt();
        startR = io.nextInt();
        startC = io.nextInt();
        maxL = io.nextLong(); // X
        maxR = io.nextLong(); // Y
        for (int i = 1; i <= N; ++i) {
            String row = io.next();
            for (int j = 1; j <= M; ++j) {
                if (row.charAt(j - 1) == '*') {
                    maze[i][j] = 1;
                }
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        // --- 0-1 BFS Implementation ---
        // Deque is used for 0-1 BFS: cost 0 moves go to front, cost 1 moves go to back.
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{startR, startC});
        dist[startR][startC] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int r = current[0];
            int c = current[1];

            for (int i = 1; i <= 4; ++i) {
                int nextR = r + DR[i];
                int nextC = c + DC[i];

                int cost = (i == 4) ? 1 : 0; // Cost 1 only for Left move (i=4)
                // Check bounds and obstacles
                if (nextR < 1 || nextR > N || nextC < 1 || nextC > M || maze[nextR][nextC] == 1) {
                    continue;
                }

                if (dist[nextR][nextC] > dist[r][c] + cost) {
                    dist[nextR][nextC] = dist[r][c] + cost;

                    if (cost == 0) {
                        queue.addFirst(new int[]{nextR, nextC});
                    } else {
                        queue.addLast(new int[]{nextR, nextC});
                    }
                }
            }
        }

        int count = 0;
        for (int r = 1; r <= N; ++r) {
            for (int c = 1; c <= M; ++c) {
                if (dist[r][c] == Integer.MAX_VALUE) continue;
                long Lmin = dist[r][c];
                long Rmin = (long)c - startC + Lmin;
                if (Lmin <= maxL && Rmin <= maxR) {
                    ++count;
                }
            }
        }

        io.println(count);
        io.close();
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
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

        @Override
        public void close() {
            super.close();
            try {
                r.close();
            } catch (IOException ignored) {
            }
        }
    }

}
