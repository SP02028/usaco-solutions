import java.io.*;
import java.util.*;

public class CP {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        while(t-->0){
            int N = io.nextInt();
            int[] arr= new int[N];
            int mex =0;
            int[] first = new int[N + 2];
            int[] last  = new int[N + 2];
            Arrays.fill(first, -1);
            Arrays.fill(last, -1);
            ArrayList<Integer> multiple = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr[i] = io.nextInt();
                if (arr[i] <= N + 1) {
                    if (first[arr[i]] == -1) first[arr[i]] = i;
                    last[arr[i]] = i;
                }

            }
            //calculate mex
            boolean[] seen = new boolean[N + 2];
            for (int x : arr)
            while (seen[mex]) mex++;
            boolean ok = false;

// CASE 1: mex + 1 exists → forced operation
            if (first[mex + 1] != -1) {
                int L = first[mex + 1];
                int R = last[mex + 1];

                // simulate overwriting this segment with mex
                for (int i = L; i <= R; i++) {
                    arr[i] = mex;
                }

                boolean[] seen2 = new boolean[N + 2];
                for (int x : arr) {
                    if (x <= N) seen2[x] = true;
                }

                int mex2 = 0;
                while (mex2 <= N && seen2[mex2]) mex2++;

                ok = (mex2 == mex + 1);
            }
            else {
                // CASE 2: mex + 1 does not exist
                for (int i = 0; i < N; i++) {
                    int v = arr[i];
                    if (v > mex || (v <= N && first[v] != last[v])) {
                        ok = true;
                        break;
                    }
                }
            }

            io.println(ok ? "YES" : "NO");

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
    }}
