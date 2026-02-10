import java.io.*;
import java.util.StringTokenizer;

public class CI2 {
    public static void main(String[] args) {
    // count frequency of all start and endpoints
        //for each k,calculate a difference array
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();
        int[][] sets = new int[N][2];
        long[] freqf = new long[M+5];
        long[] freql = new long[M+5];
        for (int i = 0; i < N; i++) {
            sets[i][0] = kattio.nextInt();
            sets[i][1] = kattio.nextInt();
            freqf[sets[i][0]]++;
            freql[sets[i][1]]++;
        }
        long[] pref = new long[2*M+5];
        for (int i = 0; i <=M ; i++) {
            for (int j = 0; j <=M ; j++) {
                pref[i+j+1] +=freqf[i] * freqf[j];
                pref[i+j+2]-= freql[i] * freql[j];
            }
        }
        for (int i = 1; i <=2*M+1 ; i++) {
            pref[i] +=pref[i-1];
            kattio.println(pref[i]);
        }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private final BufferedReader r;
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
