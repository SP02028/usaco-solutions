import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int N = io.nextInt();
		int t = io.nextInt();
		int[] arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i] = io.nextInt();
		}
		int left =0;
		int sum =0;
		int maxsum =0;
		int right;
		for( right = 0;right<N;right++) {
			sum+=arr[right];
		
		while(sum>t) {
			sum -=arr[left];
			left++;
		}
		maxsum = Math.max(maxsum, right-left+1);
		}
		io.println(maxsum);
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
