import java.io.*;
import java.util.StringTokenizer;

public class RFG {
public static void main(String[] args) {
    Kattio kattio = new Kattio();
    int T = kattio.nextInt();
    while(T-->0){
        int N = kattio.nextInt();
        int[][] races = new int[N][5];
        for (int i = 0; i < N; i++) {
            int o = kattio.nextInt();
            int t = kattio.nextInt();
            int h = kattio.nextInt();
            int f= kattio.nextInt();
            int v = kattio.nextInt();
            races[i] = new int[] {o,t,h,f,v};
        }
        int best=0;
        for (int i = 1; i < N; i++) {
            int countb = 0;
            int countn =0;
            for (int j = 0; j < 5; j++) {
                if(races[best][j] <= races[i][j]){
                    countb++;
                }
                else{
                    countn++;
                }
            }
            if(countn>=3){
                best=i;
                continue;
            }
        }
        boolean possible = true;
        for (int i = 0; i < N; i++) {
            int countb = 0;
            int countn =0;
            for (int j = 0; j < 5; j++) {
                if(races[best][j] <=races[i][j]){
                    countb++;
                }
                else{
                    countn++;
                }
            }
            if(countb<3){
                possible = false;
                break;
            }
        }
        if(!possible){
            kattio.println(-1);
        }else{
            kattio.println(best+1);
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
