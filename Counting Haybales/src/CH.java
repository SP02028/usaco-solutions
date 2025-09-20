import java.util.*;
import java.io.*;
public class CH {
	static int[] bales;
	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int N = io.nextInt();
		bales = new int[N];
		int Q = io.nextInt();
		for(int i = 0; i <N;i++) {
			bales[i] = io.nextInt();
		}
		Arrays.sort(bales);
		for(int i = 0; i <Q;i++) {
			int A = io.nextInt();
			int B = io.nextInt();
			int mostb = atMost(B);
			int lessa=atMost(A-1);
			int count = mostb-lessa;

			io.println(count);
		}
		io.close();
	}
	public static int atMost(int x) {
		int lo = 0;
		int hi = bales.length;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(bales[mid]<=x) {
				lo= mid+1;
			}
			else {
				hi=mid;
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
