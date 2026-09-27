import java.util.*;
import java.io.*;
public class MP {
    static boolean[][] visited;
    static int X, Y, K;
    static int M;
    static int mindiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Kattio io = new Kattio();
         X = io.nextInt();
         Y = io.nextInt();
         K = io.nextInt();
        M = io.nextInt();
        visited=new boolean[X+1][Y+1];
        bfs(0,0,0);
        io.println(mindiff);
        io.close();
    }
    public static void bfs(int x, int y, int k){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y,k});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            mindiff = Math.min(mindiff, Math.abs(temp[0] + temp[1] - M));
            if (temp[2] == K) continue;
            //fill state
            int[] state1 = {X, temp[1]};
            int[] state2 = {temp[0],Y};
            //empty state
            int[] state3 = {0, temp[1]};
            int[] state4 = {temp[0],0};
            //pour state
            int[] state5 = {Math.max(0, temp[0] - (Y-temp[1])), Math.min(Y, temp[0]+temp[1])};
            int[] state6 = {Math.min(X, temp[0]+temp[1]), Math.max(0, temp[1] - (X-temp[0]))};
            int[][] states = {state1, state2, state3, state4, state5, state6};
            for(int[] state:states){
                if (!visited[state[0]][state[1]]){
                    queue.add(new int[] {state[0], state[1], temp[2]+1});
                    visited[state[0]][state[1]] = true;
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
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
