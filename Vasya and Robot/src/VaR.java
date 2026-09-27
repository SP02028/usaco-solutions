import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VaR {
   static long n;
  static   String s;
    static long tx, ty;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        s = io.next();
        tx = io.nextLong();
        ty = io.nextLong();
        long totalDist = Math.abs(tx) + Math.abs(ty);
        if (totalDist > n || totalDist % 2 != n % 2) {
            io.println(-1);
            io.close();
        }
        // Binary Search for the minimum length L
        long lo = -1;
        long hi = n;

        while (hi - lo > 1) {
            long mid = lo + (hi - lo) / 2;
            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        io.println(hi);
        io.close();
    }
    // Helper function to update coordinates (cx, cy) based on move 'm' and direction 'd'
    // pos[0] = cx, pos[1] = cy
    static void upd(long[] pos, char m, int d) {
        if (m == 'U') pos[1] += d;
        else if (m == 'D') pos[1] -= d;
        else if (m == 'L') pos[0] -= d;
        else if (m == 'R') pos[0] += d;
    }
    // Checks if we can move to target
    // using exactly 'len' steps.
    static boolean can(long cx, long cy, long len) {
        long rx = tx - cx;
        long ry = ty - cy;
        long d = Math.abs(rx) + Math.abs(ry);
        if (d > len) return false;
        return (d % 2 == len % 2);
    }
    static boolean check (long l) {
        if (l > n) return false;
        long[] pos = new long[2];
        for (int i = (int)l; i < n; ++i) {
            upd(pos, s.charAt(i), 1);
        }
        long left = 0;
        long right = l;
        while (true) {
            if (can(pos[0], pos[1], l)) {
                return true;
            }
            if (right == n) break;
            upd(pos, s.charAt((int)left), 1);
            left++;
            upd(pos, s.charAt((int)right), -1);
            right++;
        }

        return false;
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

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
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

        @Override
        public void close() {
            super.close();
            try {
                r.close();
            } catch (IOException ignored) {
            }
        }
    }
}
