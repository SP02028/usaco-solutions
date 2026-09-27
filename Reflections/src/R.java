import java.io.*;
import java.util.*;

public class R {
    public static void main(String[] args) {
        /*keep track of position and direction,
at the current mirror, turn 90 degrees,
step to the next cell,
stop when you leave the grid.*/
        Kattio kattio =new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = kattio.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { return null; }
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
