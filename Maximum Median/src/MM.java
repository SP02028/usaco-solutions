import java.io.*;
import java.util.*;

public class MM {
	static int size;
	static int maxOps;
	static int[] arr;
	public static void main(String[] args) {
		Kattio io = new Kattio();

		size = io.nextInt();
		maxOps = io.nextInt();
		arr = new int[size];
		for (int i = 0; i < size; i++) { arr[i] = io.nextInt(); }
		Arrays.sort(arr);
		io.println(lastTrue(1, (int)2e9));
		io.close();
	}

	public static boolean medReachable(int x) {
		long opsNeeded = 0;
		for (int i = (size - 1) / 2; i < size; i++)
			opsNeeded += Math.max(0, x - arr[i]);
		return opsNeeded <= maxOps;
	}

	public static int lastTrue(int lo, int hi) {
		lo--;
		while (lo < hi) {
			int mid = lo + (hi - lo + 1) / 2;
			if (medReachable(mid)) {
				lo = mid;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
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
	//EndCodeSnip
}