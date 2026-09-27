import java.util.*;
import java.io.*;

public class LRC {
    static int[] next;
    static HashMap<Integer, List<int[]>> adj = new HashMap<>();
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();
        int K = kattio.nextInt();
        next = new int[N];
        for (int i = 0; i < N; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            adj.computeIfAbsent(i, k-> new ArrayList<>()).add(new int[] {a,0});
            adj.computeIfAbsent(i, k-> new ArrayList<>()).add(new int[] {b,1});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(kattio.next().equals("L")){
                sb.append("0");
            }
            else{
                sb.append("1");
            } //0 is left 1 is right
        }
        //compute where each node ends up after one cycle
        for (int i = 0; i < N; i++) {
            int curr = i;
            for (int j = 0; j < M; j++) {
                if(sb.charAt(j)=='0'){
                    List<int[]> temp = adj.get(curr);
                    int[] temp2 = temp.get(0);
                    curr = temp2[0];
                }
                else{
                    List<int[]> temp = adj.get(curr);
                    int[] temp2 = temp.get(1);
                    curr = temp2[0];
                }
            }
            next[i] = curr;
        }
        int end = 0;
        for (int i = 0; i < K; i++) {
            end = next[end];
        }
        kattio.println(end+1);
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

