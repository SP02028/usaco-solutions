import java.io.*;
import java.util.StringTokenizer;

public class MS {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
       long x1 = kattio.nextLong();
       long y1 = kattio.nextLong();
       long x2 = kattio.nextLong();
       long y2 = kattio.nextLong();
       int len = kattio.nextInt();
       String string = kattio.next();
       long[] prefx = new long[len + 1];
        long[] prefy = new long[len+1];
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == 'U') {
                prefy[i+1]=1;
            } else if (string.charAt(i)=='D') {
                prefy[i+1]=-1;
            } else if (string.charAt(i)=='R') {
                prefx[i+1]=1;
            }
            else{
                prefx[i+1]=-1;
            }
        }
        for (int i = 1; i <=len ; i++) {
            long currx = prefx[i];
            long curry = prefy[i];
            prefx[i] = prefx[i-1]+currx;
            prefy[i] = prefy[i-1]+curry;
        }
        long lo = 0;
        long hi = Long.MAX_VALUE;
        boolean found = false;
        while (lo<hi){
            long mid = lo + (hi - lo) / 2;
            long cycles = mid/len;
            int rem = (int) (mid%len);
            long x3 = x1 + (cycles*prefx[len])+prefx[rem];
            long y3 = y1 + (cycles*prefy[len])+prefy[rem];
            if(Math.abs(x2-x3)+Math.abs(y2-y3)<=mid){
                hi=mid;
                found=true;
            } else{
                lo = mid+1;
            }
        }
        if(!found) kattio.println(-1);
        else kattio.println(lo);
        kattio.close();
    }
    static class Kattio extends PrintWriter {
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
            } catch (Exception e) { return null; }
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
