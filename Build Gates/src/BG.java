

import java.io.*;
import java.util.*;
public class BG {
    private static final Map<Character, int[]> DIR = new HashMap<>() {
        {
            put('N', new int[] {-1, 0});
            put('S', new int[] {1, 0});
            put('E', new int[] {0, 1});
            put('W', new int[] {0, -1});
        }
    };
    static int Max = 1000;
    static boolean[][] grid = new boolean[4003][4003];
    static boolean[][] visited= new boolean[4003][4003];
    static int minx = Integer.MAX_VALUE;
    static int miny = Integer.MAX_VALUE;
    static int maxx = Integer.MIN_VALUE;
    static int maxy = Integer.MIN_VALUE;

    public static void main(String[] args) {
    Kattio io = new Kattio();
    int N = io.nextInt();
    String line = io.next();
    int x = Max+1;
    int y = Max+1;
    for(int i = 0;i<N;i++){
        grid[x + DIR.get(line.charAt(i))[0]][y + DIR.get(line.charAt(i))[1]] = true;
        grid[x + 2 * DIR.get(line.charAt(i))[0]][y + 2 * DIR.get(line.charAt(i))[1]] = true;

        x+=2 * DIR.get(line.charAt(i))[0];
        y+=2*DIR.get(line.charAt(i))[1];

        minx = Math.min(minx, x);
        maxx = Math.max(maxx,x);
        miny = Math.min(miny, y);
        maxy = Math.max(maxy, y);
    }
    minx--;
    maxx++;
    miny--;
    maxy++;

    int comps = 0;
        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <= maxy; j++) {
                if (!visited[i][j] && !grid[i][j]){
                    bfs(i,j);
                    comps++;
                }
            }
        }
        io.println(comps-1);
        io.close();
    }
    public static void bfs(int a, int b){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= minx && nx <= maxx &&
                        ny >= miny && ny <= maxy &&
                        !visited[nx][ny] && !grid[nx][ny]) {

                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
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
