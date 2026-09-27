import java.io.*;
import java.util.StringTokenizer;

public class TS {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();

        int N = kattio.nextInt();
        int M = kattio.nextInt();
        long[] diffArr = new long[2 * M + 2];
        long[] freqA = new long[M + 1];
        long[] freqB = new long[M + 1];

        for (int i = 0; i < N; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            freqA[a]++;
            freqB[b]++;
        }

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= M; j++) {
                long countA = freqA[i] * freqA[j];
                diffArr[i + j] += countA;
                long countB = freqB[i] * freqB[j];
                diffArr[i + j + 1] -= countB;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 2 * M; i++) {
            sum += diffArr[i];
            kattio.println(sum);
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
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                }
                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}
