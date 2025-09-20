import java.util.*;
import java.io.*;

public class AAM {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int T = io.nextInt();
        while (T-- > 0) {
            int n = io.nextInt();
            int x = io.nextInt();

            if (n % x != 0) {
                io.println(-1);
                continue;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }

            if (x == n) {
                int temp = arr[0];
                arr[0] = arr[n - 1];
                arr[n - 1] = temp;
                for (int val : arr) {
                	io.print(val + " ");
                }
                io.println();
                continue;
            }
            arr[0] = x;
            arr[n - 1] = 1;
            arr[x - 1] = n;
            int pos = x - 1;
            for (int i = 1; i < n - 1; i++) {
                if (arr[pos] % (i + 1) == 0 && arr[i] % (pos + 1) == 0) {
                    int temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                    pos = i;
                }
            }
            for (int val : arr) {
            	io.print(val + " ");
            }
            io.println();
        }
        io.close();
    }

    // Standard Kattio class for fast I/O
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

