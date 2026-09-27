import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DAC {
    static char[][][] arr =new char[100][100][100];
    static boolean[][][] vis = new boolean[100][100][100];
   static  int[] dx = {1,-1,0,0,0,0};
 static   int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int N;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
         N = kattio.nextInt();
        int counts =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String row = kattio.next();
                for (int k = 0; k < N; k++) {
                    arr[i][j][k] = row.charAt(k);
                }
            }
        }

        for(int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k = 0; k <N; k++){
                    if(!vis[i][j][k] && arr[i][j] [k] == '*'){
                        floodfill(i, j, k);
                        counts++;
                    }
                }
            }
        }
        kattio.println(counts);
        kattio.close();
    }
   /* public static void floodfill(int i, int j, int k){
        vis[i][j][k] = true;
        for (int l = 0; l < 6; l++) {
            if(i+dx[l] >=0&& i+dx[l] < N &&j+dy[l] >=0&& j+dy[l] < N&&k+dz[l] >=0&& k+dz[l] < N ){
                if(arr[i+dx[l]][j+dy[l]][k+dz[l]] == '*' && !vis[i+dx[l]][j+dy[l]][k+dz[l]]){
                    floodfill(i+dx[l], j+dy[l], k+dz[l]);
                }
            }
        }
    }*/
    //Because N was up to 100, DFS caused stack overflow; Floodfill implementation is now switched to bfs
   public static void floodfill(int startI, int startJ, int startK) {
       Queue<int[]> queue = new LinkedList<>();
       vis[startI][startJ][startK] = true;
       queue.add(new int[]{startI, startJ, startK});
       while (!queue.isEmpty()) {
           int[] curr = queue.poll();
           int i = curr[0];
           int j = curr[1];
           int k = curr[2];
           for (int l = 0; l < 6; l++) {
               int ni = i + dx[l];
               int nj = j + dy[l];
               int nk = k + dz[l];
               if (ni >= 0 && ni < N && nj >= 0 && nj < N && nk >= 0 && nk < N) {
                   if (arr[ni][nj][nk] == '*' && !vis[ni][nj][nk]) {
                       vis[ni][nj][nk] = true; //Mark when push, not when pop
                       queue.add(new int[]{ni, nj, nk});
                   }
               }
           }
       }
   }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while(this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }

                    this.st = new StringTokenizer(line);
                }

                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
