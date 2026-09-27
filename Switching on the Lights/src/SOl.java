import java.io.*;
import java.util.*;

public class SOl {
    static List<int[]>[][] lights;
    static boolean[][] lit;
    static boolean[][] visited;
    static int N;
    static int roomCount = 0;
    static boolean newLightsAdded = false;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        N = io.nextInt();
        int M = io.nextInt();

        lights = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lights[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            int x = io.nextInt() - 1;
            int y = io.nextInt() - 1;
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            lights[x][y].add(new int[]{a, b});
        }

        lit = new boolean[N][N];
        visited = new boolean[N][N];
        lit[0][0] = true;

        newLightsAdded = true;
        while (newLightsAdded) {
            newLightsAdded = false;
            visited = new boolean[N][N];
            roomCount = 0;
            floodfill(0, 0);
        }

        io.println(roomCount);
        io.close();
    }

    static boolean connected(int r, int c) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                if (visited[nr][nc]) return true;
            }
        }
        return false;
    }

    public static void floodfill(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) return;
        if (!lit[r][c]) return;
        if (visited[r][c]) return;
        if (!(r == 0 && c == 0) && !connected(r, c)) return;

        visited[r][c] = true;
        roomCount++;
        for (int[] s : lights[r][c]) {
            int lr = s[0], lc = s[1];
            if (!lit[lr][lc]) {
                lit[lr][lc] = true;
                newLightsAdded = true;
            }
        }

        floodfill(r + 1, c);
        floodfill(r - 1, c);
        floodfill(r, c + 1);
        floodfill(r, c - 1);
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
            } catch (Exception e) {}
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
