import java.util.*;
import java.io.*;
public class RC {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int T=io.nextInt();
		while(T-->0) {
		int N = io.nextInt();
		long c = io.nextInt();
		long[] arr= new long[N];
		for(int i = 0; i <N;i++) {
			arr[i] = io.nextLong();
		}
		Arrays.sort(arr);
		int coins = 0;
		for(int i = 0;i<=N-1;i++) {
			long weight = (long) (arr[i] * (Math.pow(2, i)));
			if( weight > c) {
				coins+=1;
			}
		}
		io.println(coins);
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
