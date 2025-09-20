import java.util.*;
import java.io.*;
public class AOX {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int a  = io.nextInt();
			int b = io.nextInt();
			int c = io.nextInt();
			int d = io.nextInt();
			if(a==b) {
				io.println(0);
			}
			else if(a>b) {
				if((a^1)==b) {
					io.println(d);
				}
				else {
					io.println(-1);
				}
			}
			else {
				int total = b - a;
				int odd = ((b + 1) / 2) - ((a + 1) / 2);
				int even = total - odd;

				if (d > c) {
				    // XOR is more expensive → use only +1
				    io.println(total * c);
				} else {
				    // Mix strategy: XOR on odd values
				    io.println(even * c + odd * d);
				}

			}
		}
		io.close();
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
