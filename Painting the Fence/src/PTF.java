import java.awt.event.WindowFocusListener;
import java.util.*;
import java.io.*;
public class PTF{
    public static void main(String[] args)
    {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int Q = io.nextInt();
        int[] L = new int[Q+1];
        int[] R= new int[Q+1];
        for (int i = 1; i <=Q ; i++) {
            L[i] = io.nextInt();
            R[i] = io.nextInt();
        }
        int max = -1;
        int[] diff = new int[N+2];
        for (int i = 1; i < Q; i++) {
            Arrays.fill(diff,0);
            for (int j = 1; j <=Q; j++) {
                if(j!=i){
                    diff[L[j]]++;
                    diff[R[j]+1]--;
                }


            }
            int[] prefix = new int[N+1];
            int curr = 0;
            int total = 0;
            for (int k = 1; k <=N ; k++) {
                curr+=diff[k];
                if(curr>0) total++;
                if(curr == 1) {
                    prefix[k] = prefix[k-1]+1;
                }else prefix[k] = prefix[k-1];
            }
            for (int j = 1; j <=Q; j++) {
                if(i==j) continue;
                int loss= prefix[R[j]] - prefix[L[j]-1]; // just covered by 1

                max = Math.max(max, total-loss);
            }

        }
        /*
        List<Integer>[] start = new List[N+1];
        List<Integer>[] end = new List[N+1];

        int[] active = new int[Q+1];
        int[] only = new int[Q+1];
        int[][] pair = new int[Q+1][Q+1];
        for(int i =1; i<=N;i++){
            int l = io.nextInt();
            int r = io.nextInt();
            start[l].add(i);
            end[r].add(i);
            diff[l]++;
            diff[r+1]--;
        }
        int curr = 0;
        for(int i =1; i <=N;i++){
            curr +=diff[i];
            count[i] = curr;
        }*/
        io.println(max);
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