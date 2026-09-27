import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RG {
    static List<Integer>[] adj ;
    static boolean[] visited;
    static boolean[][] reachable;
    public static void main(String[] args) {
     Kattio io = new Kattio();
     int N = io.nextInt();
     adj = new ArrayList[N];
     visited = new boolean[N];
     reachable = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            boolean before = true;
            for (int j = 0; j < N; j++) {
                int a = io.nextInt()-1;
                if(a!=i && before){
                    adj[i].add(a);
                }
                else if(a == i){
                    adj[i].add(i);
                    before = false;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            dfs(i,i);
        }
        int index = 0;
        for(List<Integer> al:  adj){
            for(int i : al){
                if(reachable[i][index]){
                    io.println(i+1);
                    break;
                }
            }
            index++;
        }
        io.close();
    }
    public static void dfs(int gift, int cow){
        if(reachable[gift][cow])
            return;

        reachable[gift][cow] = true;

        for(int i : adj[cow]){
            dfs(gift, i);
        }
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
