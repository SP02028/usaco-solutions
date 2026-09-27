import java.io.*;
import java.util.StringTokenizer;

public class ATNAR {
public static void main(String[] args) {
Kattio kattio =new Kattio();
int t = kattio.nextInt();
while(t-->0){
    int N = kattio.nextInt();
    int[] arr = new int[N];
    int sum =0;
    for (int i = 0; i < N; i++) {
        arr[i] = kattio.nextInt();
        sum += arr[i];
    }
    for (int i = N; i >=1; i--) {
        if(sum%i==0){
            long need= sum/i;
            long curr = 0;
            boolean valid = true;
            for (int j = 0; j < N; j++) {
                curr +=arr[j];
                if(curr>need){
                    valid =false;
                    break;
                }
                else if(curr==need){
                    curr =0;
                }
            }
            if(valid){
                kattio.println(N-i);
                break;
            }
        }
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
