import java.util.*;
import java.io.*;
public class M {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
         int M = kattio.nextInt();
         long[] arr = new long[N+1];
         long sum = (long) N*(N+1)/2;

        for (int i = 1; i <=N ; i++) {
            arr[i] = kattio.nextLong();

        }
        for (int i = 1; i < N; i++) {
            sum+=contrib(i, i+1, arr,N);
        }
        for (int i = 0; i < M; i++) {
            int idx = kattio.nextInt();
            long val = kattio.nextLong();
            long oldc = contrib(idx-1, idx, arr, N)+contrib(idx, idx+1, arr, N);
            sum-=oldc;
            arr[idx] = val;
            long newc = contrib(idx-1, idx, arr, N)+contrib(idx, idx+1, arr, N);;
            sum+=newc;
            kattio.println(sum);
        }
        kattio.close();
    }
    public static long contrib(int a, int b, long[] arr, int N){
        if (a < 1 || a >= N) {
            return 0;
        }

        if(arr[a] != arr[b]){
                return (long) a * (N-a);
        }
        else return 0;
    }
    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
