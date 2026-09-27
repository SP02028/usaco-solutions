import java.io.*;
import java.util.StringTokenizer;

public class LO3{
    public static void main(String[] args) throws IOException{
        Kattio kattio =new Kattio("leftout");
        int N = kattio.nextInt();
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = kattio.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j); // 'L' or 'R'
            }
        }

        for (int j = 0; j < N; j++) {
            if (grid[0][j] == 'L') flipCol(grid, N, j);
        }
        for (int i = 0; i < N; i++) {
            if (grid[i][0] == 'L') flipRow(grid, N, i);
        }
        int allR = num(grid, 1, 1, N - 1, N - 1, 'R');
        int allL = num(grid, 1, 1, N - 1, N - 1, 'L');
        if (allR == 0) {
            kattio.println("1 1");
            kattio.close();
            
        }
        if (allL == N - 1) {
            for (int j = 1; j < N; j++) {
                if (num(grid, 1, j, N - 1, j, 'L') == N - 1) {
                    kattio.println("1 " + (j + 1));
                    kattio.close();
                    
                }
            }
            for (int i = 1; i < N; i++) {
                if (num(grid, i, 1, i, N - 1, 'L') == N - 1) {
                    kattio.println((i + 1) + " 1");
                    kattio.close();
                }
            }
            kattio.println("-1");
            kattio.close();
        }
        if (allL != 1) {
            kattio.println("-1");
            kattio.close();
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (grid[i][j] == 'L') {
                    kattio.println((i + 1) + " " + (j + 1));
                    kattio.close();
    
                }
            }
        }

        kattio.println("-1");
        kattio.close();
    }

    public static void flipRow(char[][] grid, int N, int r) {
        for (int j = 0; j < N; j++) grid[r][j] = flip(grid[r][j]);
    }

    public static void flipCol(char[][] grid, int N, int c) {
        for (int i = 0; i < N; i++) grid[i][c] = flip(grid[i][c]);
    }

    public static char flip(char c) {
        return (c == 'L') ? 'R' : 'L';
    }

    public static int num(char[][] grid, int i1, int j1, int i2, int j2, char target) {
        int total = 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (grid[i][j] == target) total++;
            }
        }
        return total;
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
