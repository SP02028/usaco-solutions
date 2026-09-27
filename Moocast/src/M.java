import java.io.*;
import java.util.*;
public class M {

    static boolean[] visited;

    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        int[][] coords = new int[N][2];
        for (int i = 0; i < N; i++) {
            int a = io.nextInt();
            int b =io.nextInt();
            coords[i][0]=a;
            coords[i][1] =b;
        }
        int[][] dists = new int[N][N];
        List<Integer> posX = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double dx = coords[i][0] - coords[j][0];
                double dy = coords[i][1] - coords[j][1];
                int dist = (int) (dx*dx+dy*dy);
                dists[i][j]=dist;
                dists[j][i]=dist;
                posX.add(dist);
            }
        }
        int low =0;
        int high = posX.size()-1;
        int result = -1;
        Collections.sort(posX);
        visited=new boolean[N];
        while(low<=high){
            Arrays.fill(visited, false);
            int mid= low + (high-low)/2;
            List<Integer>[] adj= new List[N];
            for (int i = 0; i < N; i++) {
                adj[i]=new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(dists[i][j]<= posX.get(mid)){
                        adj[i].add(j);
                    }
                }
            }
            dfs(0,adj);
            if(canreach(visited)){
                result = posX.get(mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        io.println(result);
        io.close();
    }

    static void dfs(int s, List<Integer>[] adj){
        if (visited[s]) return;
        visited[s] = true;
        for (int nbr : adj[s]) {
            if (!visited[nbr]){
                dfs(nbr, adj);
            }
        }
    }
    static boolean canreach (boolean[] visited){
        for(boolean b: visited){
            if(!b){
                return false;
            }
        }
        return true;
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