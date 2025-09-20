import java.util.*;
import java.util.function.Predicate;
import java.io.*;
public class MMM {
		public static void main(String[] args) throws IOException {
			Kattio io= new Kattio();
			int t = io.nextInt();
			while (t-- > 0) {
				int n = io.nextInt();
				int k = io.nextInt();
				int[] a = new int[n];
				for (int i = 0; i < n; i++) a[i] = io.nextInt();
				int ans = lastTrue(0, n + 1, x -> {
					int count = 0;
					Set<Integer> seen = new HashSet<>();
					for (int i = 0; i < n; i++) {
						if (a[i] < x) {
							seen.add(a[i]);
						}
						if (seen.size() == x) {
							count++;
							seen.clear();
						}
					}
					return count >= k;
				});
				io.println(ans);
			}
			io.flush();
		}

		public static int lastTrue(int lo, int hi, Predicate<Integer> f) {
			lo--;
			while (lo < hi) {
				int mid = lo + (hi - lo + 1) / 2;
				if (f.test(mid)) {
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
}
