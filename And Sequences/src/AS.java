import java.util.*;
import java.io.*;
public class AS {
	static final int MOD = 1_000_000_007;
	static final int MAX = 200_005; 
	static long[] fact = new long[MAX];

	static void precomputeFactorials() {
	    fact[0] = 1;
	    for (int i = 1; i < MAX; i++) {
	        fact[i] = (fact[i - 1] * i) % MOD;
	    }
	}
	public static void main(String[] args) {
		precomputeFactorials();
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int len = io.nextInt();
			int[] arr = new int[len];
			arr[0] = io.nextInt();
			int and = arr[0];
			for(int i = 1; i <len;i++) {
				arr[i] = io.nextInt();
				and = arr[i] & and;
			}
			boolean pos = true;
			for(int i = 0; i < len;i++) {
				if((arr[i]& and) !=and) {
					pos = false;
					break;
				}
			}
			if(!pos) {
				io.println(0);
			}
			else {
				int count = 0;
				for(int i = 0; i < len;i++) {
					if(arr[i] ==and) {
						count++;
					}
				}
				if(count>=2) {
					long result = count;
					result = (result * (count - 1)) % MOD;
					result = (result * fact[len - 2]) % MOD;
					io.println(result);
				}
				else {
					io.println(0);
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
