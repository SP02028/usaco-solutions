import java.io.*;
import java.util.StringTokenizer;

public class FM {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T=kattio.nextInt();
        while(T-->0){
           long x = kattio.nextLong();
           long y = kattio.nextLong();
           long  ans = 0;
            for (int i = 1; i*i<=x ; i++) {
                long maxb = (x/i)-1;
                long bmin = i+1;
                long upperb = Math.min(y, maxb);
                if(upperb>=bmin) ans+=upperb-bmin+1;
           /*     long hi = i-1;
                long lo=0;
                while(lo<hi){
                    long mid = (lo+hi+1)/2;
                    if(mid*i+mid <=x){
                        lo=mid;//i know that these are the problem
                    }else{
                       hi=mid-1;
                    }
                }
                ans+=lo;*/

            }
            kattio.println(ans);
        }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

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
