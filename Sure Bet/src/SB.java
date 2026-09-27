import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SB {
    public static void main(String[] args) {
        Kattio kattio= new Kattio();
        int N= kattio.nextInt();
        Double[] a =new Double[N];
        Double[] b = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = kattio .nextDouble()-1;
            b[i] = kattio.nextDouble()-1;
        }
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());
        int pointer =0;
        double ans= 0;
        double curra =0;
        double currb = 0;
        for (int i = 0; i < N; i++) {
            curra += a[i];
            currb--;
            while(pointer<N){
                double newA = curra-1;
                double newB = currb + b[pointer];
                if(Math.min(curra, currb)<Math.min(newA, newB)){
                    pointer++;
                    curra = newA;
                    currb = newB;
                }
                else{
                    break;
                }
            }
            ans = Math.max(ans, Math.min(curra, currb));
        }
        System.out.printf("%.4f", ans);
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

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
