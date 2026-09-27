import java.io.*;
import java. util. ArrayList;
import java. util.Arrays;
import java. util.List;
import java.util. StringTokenizer;

public class STM {
    static char[][] grid;
    static int N;
    static int M;
    static int currentSize;
    static boolean[][] visited;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while(t-->0){
            M = io.nextInt();
            N = io.nextInt();
            grid = new char[M][N];
            visited = new boolean[M][N];
            List<int[]> bpos = new ArrayList<>();
            List<int[]> gpos = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String line = io.next();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = line. charAt(j);
                    if (grid[i][j] == 'B') {
                        bpos. add(new int[] {i,j});
                    }
                    else if (grid[i][j]=='G'){
                        gpos.add(new int[] {i,j});
                    }
                }
            }
            boolean valid = true;
            for(int[] l:bpos){
                int up = isadj(l[0]+1, l[1]);
                if(up==1){
                    grid[l[0]+1][l[1]]='#';
                }
                int down = isadj(l[0]-1, l[1]);
                if(down==1){
                    grid[l[0]-1][l[1]]='#';
                }
                int right = isadj(l[0], l[1]+1);
                if(right==1){
                    grid[l[0]][l[1]+1]='#';
                }
                int left = isadj(l[0], l[1]-1);
                if(left==1){
                    grid[l[0]][l[1]-1]='#';
                }
                if(up==2||down==2||left ==2||right==2){
                    valid = false;
                }
            }
            if(!valid){
                io.println("No");
                continue;
            }

            boolean reachable = true;
            if(grid[M-1][N-1] != '#' && grid[M-1][N-1] != 'B') {
                floodfill(M-1, N-1, '.');
            }

            for(int[] l : gpos) {
                if(! visited[l[0]][l[1]]) {
                    reachable = false;
                    break;
                }
            }

            if(reachable){
                io.println("Yes");
            }else{
                io.println("No");
            }
        }
        io.close();
    }

    public static int isadj(int a, int b){ //0 if out of bounds, 1 if can put wall, 2 if there's a good person
        if(a <0 || b<0 || a>M-1 || b>N-1){
            return 0;
        } else if (grid[a][b] == 'G' ) {
            return 2;
        }
        return 1;
    }

    public static void floodfill(int r, int c, char color){
        if(r<0 || c<0 || r>M-1 || c >N-1){
            return;
        }
        if(grid[r][c]=='#' || grid[r][c] == 'B'){
            return;
        }
        if(visited[r][c]){
            return;
        }
        visited[r][c] = true;
        currentSize++;

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