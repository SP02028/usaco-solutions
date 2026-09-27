import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class MiE {
    public static void main(String[] args) {
     Kattio io = new Kattio();
        int n;
        long k;
        n = io.nextInt();
        k = io.nextLong();

        int a;
        int mx = 0;
        int mn = Integer.MAX_VALUE;
        int[] sum = new int[2001001];

        for (int i = 0; i < n; i++) {
            a = io.nextInt();
            sum[a]++;
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }

        for (int i = mx - 1; i >= 1; i--) {
            sum[i] += sum[i + 1];
        }

        int y = 0;
        int x = mx;
        int count = 0;
        while (x > mn) {
            if (sum[x] + y <= k) {
                y += sum[x];
                x--;
            } else {
                y = 0;
                count++;
            }
        }

        if (y != 0) {
            count++;
        }

        io.println(count);
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public long nextLong() {
            // TODO Auto-generated method stub
            return Long.parseLong(next())	;	}
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
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}
