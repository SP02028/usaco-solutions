import java.util.*;
import java.io.*;
public class DM {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int K = kattio.nextInt();
        List<Integer>[] visited = new List[N];
        int[] cows=  new int[N];
        Arrays.fill(cows,-1);
        for (int i = 0; i < N; i++) {
            cows[i] = i;
            visited[i] = new ArrayList<>();
            visited[i].add(i);
        }
        for (int i = 0; i < K; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            int c = cows[a];
            int d = cows[b];
            cows[a] = d;
            cows[b] = c;
            visited[cows[a]].add(a);
            visited[cows[b]].add(b);

        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            if(cows[i]!=-1){
                List<Integer> cycle = new ArrayList<>();
                int j = i;
                while(cows[i] !=-1){
                    cycle.add(i);
                    i = cows[i];
                    cows[cycle.get(cycle.size()-1)]=-1;
                }
                Set<Integer> viewed = new HashSet<>();
                for(int cow: cycle){
                    viewed.addAll(visited[cow]);
                }
                for(int cow:cycle){
                    ans[cow] = viewed.size();
                }
            }

        }
        for (int i = 0; i < N; i++) {
            kattio.println(ans[i]);
        }
        kattio.close();
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
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
