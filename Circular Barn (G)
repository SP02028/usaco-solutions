import javax.naming.PartialResultException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CBS3 {
    public static void main(String[] args) throws IOException{
        Kattio kattio = new Kattio("cbarn");
        int N = kattio.nextInt();
        List<Long> cows = new ArrayList<Long>();
        long c = 0;
        for (int i = 0; i < N; i++) {
            cows.add(kattio.nextLong());
            c = Math.max(0, c+ cows.get(i)-1);
        }
        for (int i = 0;; i++) {
            if(c==0){
                Collections.rotate(cows.subList(0,N),N-i);
                break;
            }
            c = Math.max(0L, c + cows.get(i)-1);
        }
        long result=0;
        for (int i = 0; i < N; i++) {
            result += sum2(cows.get(i)+c-1)-sum2(c-1);
            c= Math.max(0L, c+ cows.get(i)-1);
        }
    kattio.println(result);
        kattio.close();
    }
    public static long sum2 (long v){
        return v*(v+1)*(2*v+1)/6;
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
        public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
    }
}
