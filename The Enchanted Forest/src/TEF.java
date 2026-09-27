import java.util.*;
import java.io.*;
public class TEF {
public static void main(String[] args) {
    Kattio kattio = new Kattio();
    int T = kattio.nextInt();
    while(T-->0){
        int N = kattio.nextInt();
        long k = kattio.nextLong();
        long[] arr = new long[N+1];
        long sum =0 ;
        for (int i = 1; i <=N; i++) {
            arr[i] = kattio.nextLong();
            sum+=arr[i];
        }
        if(N>k){
            //prefix sum to find a maximal subarray of len k + (k-1)*k/2
            long[] pref = new long[N+1];
            for (int i = 1; i <=N; i++) {
                pref[i] = pref[i-1] + arr[i];
            }
            long max = -1;
            for(long i = k;i<=N;i++){
                long p = pref[(int) i]- pref[(int) (i- k)];
                max = Math.max(max, p + k*(k-1)/2);
            }
            kattio.println(max);
        }
        else{
            long bonus = (long) N * (k - 1) - ((long) N * (N - 1)) / 2;
            kattio.println(sum + bonus);
        }
    }
    kattio.close();
}
    static class Kattio extends
            PrintWriter {
        private final BufferedReader r;
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
