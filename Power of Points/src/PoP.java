import java.io.*;
import java.util.*;

public class PoP {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt(); 
        while (t-- > 0) {
            long n = io.nextLong(); 
            long[] x = new long[(int) n];
            for (int i = 0; i < n; i++) {
                x[i] = io.nextLong();
            }
            long[][] p = new long[(int) n][2];
            for (int i = 0; i < n; i++) {
                p[i][0] = x[i];
                p[i][1] = i;    
            }

            Arrays.sort(p, (a, b) -> Long.compare(a[0], b[0]));

            long val = 0;
            for (int i = 0; i < n; i++) {
                val += (p[i][0] - p[0][0] + 1);
            }
            long[] ans = new long[(int) n];
            ans[(int) p[0][1]] = val;
            for (int i = 1; i < n; i++) {
                long diff = p[i][0] - p[i - 1][0];
                val -= (n - i) * diff;
                val += (long) i * diff;
                ans[(int) p[i][1]] = val;
            }
            for (int i = 0; i < n; i++) {
                io.print(ans[i] + " ");
            }
            io.println();
        }

        io.flush();
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
