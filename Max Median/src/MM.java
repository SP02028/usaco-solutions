import java.io.*;
import java.util.StringTokenizer;

public class MM {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int K = kattio.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kattio.nextInt();
        }
        int lo = 1;
        int hi = N;
        while(lo<hi){
            int med = (lo+hi+1)/2;
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                if(arr[i] >=med){
                    a[i] = 1;
                }else a[i] = -1;
                if(i>0) a[i] +=a[i-1];
            }
            int min = 0;
            int diff = 0;
            for (int i = K-1; i < N ; i++) {
                if(i-K>=0) min = Math.min(min, a[i-K]);
                diff = Math.max(diff, a[i] - min);
            }
            if(diff>0) lo = med;
            else hi = med-1;
        }
        kattio.println(lo);
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
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
