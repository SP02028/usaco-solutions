import java.io.*;
import java.util.StringTokenizer;

public class IP {
    static char[][] grid;
    static int N;
    static boolean[][] visited;
    static int currentSize=0;
    static int perimeter=0;
public static void main(String[] args) {
    Kattio io = new Kattio();
    int n = io.nextInt();
    N=n;
    grid = new char[N][N];
    for (int i = 0; i < N; i++) {
        String line = io.next();
        for (int j = 0; j < N; j++) {
            grid[i][j] = line.charAt(j);
        }
    }
    int maxa = -1;
    int minp = Integer.MAX_VALUE;
    visited = new boolean[N][N];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
                currentSize = 0;
                perimeter = 0;
                floodfill(i, j, '#');
                int a = currentSize;
                int p = perimeter;
                if(a==maxa){

                    minp = Math.min(p, minp);
                }
                else if (a > maxa) {
                    maxa = a;
                    minp = p;
                }
            }
        }
    }
    io.println(maxa + " " + minp);
    io.close();
}
public static void floodfill(int r, int c, char color){
    if(r<0 || c<0 || r>N-1 || c >N-1){
        return;
    }
    if(grid[r][c]!=color){
        return;
    }
    if(visited[r][c]){
        return;
    }
    visited[r][c] = true;
    currentSize++;
    // Check all 4 directions - if neighbor is different or out of bounds, it's a perimeter edge
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if (nr < 0 || nc < 0 || nr >= N || nc >= N || grid[nr][nc] != color) {
            perimeter++;
        }
    }

    floodfill(r,c+1, color);
    floodfill(r, c-1, color);
    floodfill(r-1, c, color);
    floodfill(r+1, c, color);
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
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

}
