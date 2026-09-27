import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class MG {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            long[] swords = new long[N];
            int[] monsters = new int[N];
            long maxsword = -1;
            for (int i = 0; i < N; i++) {
                swords[i] = kattio.nextLong();
                maxsword= Math.max(maxsword,swords[i]);
            }
            Arrays.sort(swords);
            for (int i = 0; i < N; i++) {
                monsters[i] = kattio.nextInt();
            }
            long[] pref = new long[N];
            pref[0] = monsters[0];
            for (int i = 1; i < N; i++) {
                pref[i] = pref[i-1] + monsters[i];
            }
            long max = 0;
           int i =0;
           while(i<N)
           {
               long a = swords[i];
               int k = N-i;
               int K = upperBound(pref,k)-1;
               if(K>=0){
                   max = Math.max(max, a*(K+1));
               }
               long val = swords[i];
               while(i<N && swords[i] == val)i++;
           }
            kattio.println(max);
        }
        kattio.close();
    }
    static int upperBound(long[] arr, long k){
        int lo =0;
        int hi = arr.length;
        while(lo<hi){
            int mid = (lo+hi) >>>1;
            if(arr[mid] <=k) lo = mid+1;
            else hi =mid;
        }
        return lo;
    }
    static long levels(long[] swords, long[] monsters, long diff){
        long count = 0;
        for (int i = 0; i < swords.length; i++) {
            if(swords[i] >=diff){
                count++;
            }
        }
        long l = 0;
        for (int i = 0; i < monsters.length; i++) {
            if(count>monsters[i]){
                l++;

            }
            else{
                break;
            }
        }
        return l;
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Input and output as System.in and System.out
        public Kattio() {
            this(System.in, System.out);
        }

        // Input and output streams
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // Read the next token
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

        // Next integer
        public int nextInt() {
            return Integer.parseInt(next());
        }

        // Next long
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
