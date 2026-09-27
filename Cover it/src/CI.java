import java.util.*;
import java.io.*;
public class CI {
   static int[] colors;
   static int rcount = 0;
   static int bcount = 0;
   static boolean[] visited;
   static List<Integer>[] adj;
   public static void main(String[] args){
       Kattio io = new Kattio();
       int tc = io.nextInt();
       while (tc-->0){
           int v = io.nextInt();
           int e = io.nextInt();
           adj = new ArrayList[v];
           for(int i=0;i<v;i++){
               adj[i] = new ArrayList<>();
           }
           visited = new boolean[v];
           colors = new int[v];
           for(int i = 0;i<e;i++){
               int a = io.nextInt()-1;
               int b = io.nextInt()-1;
               adj[a].add(b);
               adj[b].add(a);
           }
           bcount=0;
           rcount = 0;
           for (int i = 0; i < v; i++) {
                if(colors[i]==0){
                    colors[i]=1;
                    dfs(i);
                }
           }
           List<Integer> reds = new ArrayList<>();
           List<Integer> blues = new ArrayList<>();
           for (int i = 0; i < v; i++) {
               if(colors[i]==1) {
                   rcount++;
                   reds.add(i);
               }
               else {
                   bcount++;
                blues.add(i);
               }
           }
           if(rcount<bcount){
               io.println(rcount);
               for(int i: reds){
                   io.print(i+1+" ");
               }
               io.println();
           }
           else {
               io.println(bcount);
                for(int i:blues){
                    io.print(i+1 + " ");
                }
                io.println();
           }
       }
       io.close();
   }
   public static void dfs(int v){
       if(visited[v]){
           return;
       }
       int next = 3-colors[v];
       visited[v]= true;
       for(int nbr: adj[v]){
        if(colors[nbr]==0){
            colors[nbr]=next;
            dfs(nbr);
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
