import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OutOfMemoryError {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T=  kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            int M = kattio.nextInt();
            long h = kattio.nextLong();
            long[] og = new long[N];
            for (int i = 0; i < N; i++) {
                og[i] = kattio.nextLong();
            }
            long[] delta = new long[N];
            int[] last = new int[N];
            int v =  1;
            for (int i = 0; i < M; i++) {
                int a = kattio.nextInt()-1;
                long b = kattio.nextLong();
                long curr = 0;
                if(last[a] == v){
                    curr = og[a]+delta[a];
                } else{
                    curr = og[a];
                }
                if(curr+b>h){
                    v++;
                }else{
                    if(last[a] == v){
                        delta[a] +=b;
                    }else{
                        delta[a] = b;
                        last[a] = v;
                    }
                }

            }
            for (int i = 0; i < N; i++) {
                if(last[i]== v){
                    kattio.print(og[i]+ delta[i] + " ");
                } else{
                    kattio.print(og[i] + " ");
                }
            }
            kattio.println();
        }
        kattio.close();
    }
    static class Kattio extends
            PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
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
        public long nextLong() { return Long.parseLong(next()); }
    }
}
