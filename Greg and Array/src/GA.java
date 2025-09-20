import java.util.*;
import java.io.*;
public class GA {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		long n = io.nextLong();
		long m = io.nextLong();
		long q = io.nextLong();
		long[] a = new long[(int)n + 1];
		for (int i = 1; i <= n; i++) {
		    a[i] = io.nextLong();
		}
		long[][] arr = new long[(int) m][3];
		for(int i = 0; i <m;i++) {
			long x = io.nextLong();
			long b = io.nextLong();
			long c = io.nextLong();
			arr[i][0] = x;
			arr[i][1] = b;
			arr[i][2] = c;
		}
		long[] count = new long[(int) (m+2)];
		for(int i = 0; i <q;i++) {
			long x = io.nextLong();
			long b = io.nextLong();
			update(count, x, b, 1);
		}
		long[] times =new long[(int) (m+1)];
		for (int i = 1; i <= m; i++) {
		    times[i] = times[i - 1] + count[i];
		}
		long[] arrdiff = new long[(int)(n+2)];
		for(int i = 0; i <m;i++) {
			update(arrdiff, arr[i][0], arr[i][1], arr[i][2] * times[i + 1]);
		}
		long[] finarr =new long[(int) (n+1)];
	    finarr[0] = arrdiff[0];
	    for (int i = 1; i <= n; i++) {
	        finarr[i] = finarr[i - 1] + arrdiff[i];
	    }
	    for(int i = 1; i <= n; i++) {
	        a[i] += finarr[i];
	        io.print(a[i] + " ");
	    }
	    io.close();
	}
	static void update(long[] arr, long l, long r, long x) {
        arr[(int) l] = arr[(int) l] + x;
        if (r + 1 < arr.length) {
            arr[(int) (r + 1)] -= x;
        }
    }
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
