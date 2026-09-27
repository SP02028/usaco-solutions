import java.io.*;
import java.util.*;

public class SM {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();

        while (t-- > 0) {
            int n = io.nextInt();
            int m = n * 2;
            long[] a = new long[m + 1];
            long ans = 0;
            long sum = 0;

            for (int i = 1; i <= m; i++) {
                a[i] = io.nextLong();
                ans += Math.abs(a[i]);
                sum += Math.abs(a[i] - (-1));
            }

            // Case n = 1: Target array [x, x] where x is any value
            if (n == 1) {
                ans = Math.min(ans, Math.abs(a[1] - a[2]));
            }
            // Case n = 2: Target array [2, 2, 2, 2]
            if (n == 2) {
                long d2 = 0;
                for (int i = 1; i <= m; i++) {
                    d2 += Math.abs(a[i] - 2);
                }
                ans = Math.min(ans, d2);
            }
            // Case n is even: Target array [n, -1, -1, ..., -1]
            if (n % 2 == 0) {
                for (int i = 1; i <= m; i++) {
                    long cur = sum - Math.abs(a[i] - (-1)) + Math.abs(a[i] - n);
                    ans = Math.min(ans, cur);
                }
            }
            io.println(ans);
        }
        io.close();
    }
}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    public Kattio() { this(System.in, System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) { return null; }
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}