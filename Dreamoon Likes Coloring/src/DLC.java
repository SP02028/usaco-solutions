import java.util.*;
import java.io.*;
public class DLC {
public static void main(String[] args) {
    Kattio kattio =new Kattio();
    int N = kattio.nextInt();
    int m = kattio.nextInt();
    int[] l = new int[m+1];
    long[] suffix = new long[m+2];
    for (int i = 1; i <=m; i++) {
        l[i] = kattio.nextInt();
        if(l[i] + i- 1 > N){
            kattio.println(-1);
            kattio.close();
        }
    }
    for (int i = m; i >0 ; i--) {
        suffix[i] = suffix[i+1] +l[i];
    }
    if(suffix[1] <N){
        kattio.println(-1);
        kattio.close();
    }
    for (int i = 1; i <=m; i++) {
        long pi = Math.max(i, N-suffix[i]+1);
        kattio.print(pi + " ");
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
