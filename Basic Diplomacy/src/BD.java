import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BD {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            int m = kattio.nextInt();

            List<List<Integer>> ppl = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                ppl.add(new ArrayList<>());
            }

            int[] initial = new int[m];
            int[] tempfreq = new int[N];
            for (int i = 0; i < m; i++) {
                int c = kattio.nextInt();
                for (int j = 0; j < c; j++) {
                    int a = kattio.nextInt() - 1;
                    ppl.get(i).add(a);
                }

                initial[i] = ppl.get(i).getFirst();
                tempfreq[initial[i]]++;
            }

            int over =-1;
            int L = (m+1)/2;
            for (int i = 0; i < N; i++) {
                if(tempfreq[i] > L){
                    over = i;
                    break;
                }
            }
            if(over == -1){
                kattio.println("YES");
                for (int i = 0; i < m; i++) {
                    kattio.print(initial[i]+1 + " ");
                }
                kattio.println();
                continue;
            }
            int count =  tempfreq[over] - L;

            for (int i = 0; i < m; i++) {
                if(count == 0) break;

                if(initial[i] == over){
                    if (ppl.get(i).size() > 1){
                        initial[i] = ppl.get(i).get(1);
                        count--;
                    }
                }
            }

            if(count > 0){
                kattio.println("NO");
            }
            else{
                kattio.println("YES");
                for (int i = 0; i < m; i++) {
                    kattio.print(initial[i]+1 + " ");
                }
                kattio.println();
            }
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
