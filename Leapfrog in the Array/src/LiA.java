import java.util.*;
import java.io.*;
public class LiA {



        public static long solve(long index, long n){
            if(index % 2 == 1){
                return (index + 1) / 2;
            }
            return solve(n + (index / 2), n);
        }

        public static void main(String[] args){
Kattio kattio = new Kattio();
            long n = kattio.nextLong();
            int q = kattio.nextInt();
            for(int i = 0; i < q; i++){
               long x = kattio.nextLong();
                System.out.println(solve(x, n));
            }


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
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

}
