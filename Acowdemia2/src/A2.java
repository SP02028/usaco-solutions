//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class A2 {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int K = kattio.nextInt();
        int L = kattio.nextInt();
        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = kattio.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int lo = 0;
        int hi = N;

        while(lo < hi) {
            int r = lo + (hi-lo) / 2;
            long n = 0L;

            for(int i = 0; i < r; ++i) {
                n += (long)Math.max(0, r - arr[i]);
            }

            if (n <= (long)K * (long)L && arr[r - 1] + K >= r) {
                lo = r;
            } else {
                hi = r - 1;
            }
        }

        kattio.println(hi);
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
                while(this.st == null || !this.st.hasMoreTokens()) {
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

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
