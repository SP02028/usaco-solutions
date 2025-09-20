import java.util.*;
import java.io.*;
public class EFATLN {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int T = io.nextInt();
        ArrayList<Long> arr = new ArrayList<Long>();
        arr.add(0L);
        for (long i = 1; i <= Math.pow(10, 18); i++) {
            int sqrt = (int) Math.sqrt(i);
            if (i % sqrt == 0) {
                arr.add(1L);
            } else {
                arr.add(0L);
            }
        }
        ArrayList<Long> pref = new ArrayList<Long>();
        pref.add(0L);
        for (int i = 1; i < arr.size(); i++) { 
            pref.add(pref.get(i - 1) + arr.get(i));
        }
        while (T-- > 0) {
            long l = io.nextLong();
            long r = io.nextLong();
            io.println(pref.get((int) r) - pref.get((int) (l - 1)));
        }
        io.close();
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
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
