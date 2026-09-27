import java.io.*;
import java.util.StringTokenizer;

public class MOS {
    static char[][] grid;
    static boolean[][] visited;
    static int currentSize;
    static int M, N;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        M =kattio.nextInt();
        N= kattio.nextInt();
        int q = kattio.nextInt();
        int xposs = 0;
        int yposs = 0;
        grid = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String line = kattio.next();
            for (int j = 0; j < N; j++) {
                grid[i][j]= line.charAt(j);
                if(line.charAt(j)=='S'){
                    xposs = j;
                    yposs = i;
                }
            }
        }
        floodfill(yposs, xposs);
        kattio.println(currentSize);
        for (int i = 0; i < q; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            grid[a][b] = '#';
            int up = isadj(a+1, b);
          //  System.out.println("upres: "+  up);
            int down = isadj(a-1,b);
           // System.out.println("downres: "+ down);
            int left = isadj(a, b-1);
           // System.out.println("leftres: "+  left);
            int right = isadj(a, b+1);
           // System.out.println("rightres:" +  right);
            if(up ==1||down==1||left==1||right==1){
             // System.out.println("floodfillinggggg");
                floodfill(a,b);
            }
            kattio.println(currentSize);
        }
        kattio.close();
    }
    public static int isadj(int a, int b){ //0 if oob, 1 if yes, 2 if no
        if(a <0 || b<0 || a>M-1 || b>N-1){
            return 0;
        } else if (grid[a][b] != 'C' ) {
            return 2;
        }
        return 1;
    }
    public static void floodfill(int r, int c){
        if(r<0 || c<0 || r>M-1 || c >N-1){
            return;
        }
        if(grid[r][c]=='.'){
            return;
        }
        if(visited[r][c]){
            return;
        }
        visited[r][c] = true;
        grid[r][c] = 'C';
        currentSize++;

        floodfill(r,c+1);
        floodfill(r, c-1);
        floodfill(r-1, c);
        floodfill(r+1, c);
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
                while (st == null || ! st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st. nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long. parseLong(next()); }
    }
}
