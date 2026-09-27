import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
public class M {
    static Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Kattio io =  new Kattio();
        int N = io.nextInt();
        int Q = io.nextInt();
        for (int i = 0; i < N-1; i++) {
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            int w = io.nextInt();
            adj.computeIfAbsent(a,k -> new ArrayList<int[]>()).add(new int[]{b,w});
            adj.computeIfAbsent(b,k -> new ArrayList<int[]>()).add(new int[]{a,w});
        }
        visited = new boolean[N];
        for (int i = 0; i < Q; i++) {
            int r = io.nextInt();
            int n = io.nextInt()-1;
            int count = 0;
            visited = new boolean[N];
            Queue<Integer> queue= new LinkedList<Integer>();
            queue.add(n);
            visited[n]= true;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int[] arr: adj.get(node)){
                    if(!visited[arr[0]]&& arr[1]>=r){
                        visited[arr[0]]=true;
                        queue.add(arr[0]);
                        count++;
                    }
                }

            }
            io.println(count);
        }
        io.close();
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
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
