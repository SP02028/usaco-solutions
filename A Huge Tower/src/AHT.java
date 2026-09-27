import java.io.*;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AHT {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int D = kattio.nextInt();
        int[] blocks = new int[N];
        for (int i = 0; i < N; i++) {
            blocks[i] = kattio.nextInt();
        }
        Arrays.sort(blocks);
        int right= 0;
        long ans = 1;
        for (int l = 0; l < N; l++) {
            while(right<N-1 && blocks[right+1]-blocks[l]<=D) right++;
            int dist = right-l+1;
            ans = (ans*dist)%1000000009;
        }
        kattio.println(ans);
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
