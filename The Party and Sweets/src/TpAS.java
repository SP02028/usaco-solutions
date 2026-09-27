import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TpAS {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int B = kattio.nextInt();
        int G = kattio.nextInt();
        long minb = Long.MAX_VALUE;
        long maxb = 0;
        long sumb = 0;
        long maxg = 0;
        long ming = Long.MAX_VALUE;
        long sumg =0 ;
        long[] arr = new long[B];
        for (int i = 0; i < B; i++) {
            long b = kattio.nextLong();
            minb = Math.min(b, minb);
            maxb = Math.max(b, maxb);
            sumb +=b;
            arr[i] = b;
        }
        Arrays.sort(arr);
        boolean invalid = false;
        for (int i = 0; i < G; i++) {
            long g = kattio.nextLong();
            maxg = Math.max(g, maxg);
            sumg +=g;
            ming = Math.min(ming, g);
        }
        if(ming<maxb) invalid = true;
    if(invalid) kattio.println(-1);
    else if(maxb == ming){
        kattio.println(sumb*G + sumg - maxb*G);
    } else{
        kattio.println(sumb * G + sumg - maxb*(G-1) - arr[B-2]);
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
