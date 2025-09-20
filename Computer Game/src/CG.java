import java.util.*;
import java.io.*;
public class CG {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			long k =io.nextLong();
			long n = io.nextLong();
			long a=io.nextLong();
			long b = io.nextLong();
			if(n*b>=k) {
				io.println(-1);
			}
			else {
				long x = (k - b * n - 1) / (a - b);
		        long ans = Math.min(n, Math.max(0, x));
		        io.println(ans);
			}
	}
		io.close();

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
	//EndCodeSnip
}