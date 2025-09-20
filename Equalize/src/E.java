import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;;
public class E {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int len = io.nextInt();
			int[] arr = new int[len];
			for(int i = 0;i<len;i++) {
				arr[i] = io.nextInt();
			}
			Set<Integer> s = new HashSet<Integer>();
			for(int a:arr) {
				s.add(a);
			}
			int[] newarr = new int[s.size()];
			int count = 0;
			for(int ele:s) {
				newarr[count] = ele;
				count++;
			}
		Arrays.sort(newarr);
			//find max length subarray such that max val - minval >=len-1
		int l = 0;
		int ans = 0;
		for (int r = 0; r < newarr.length; r++) {
			while (newarr[r] - newarr[l] > len - 1) {
				l++;
			}
			ans = Math.max(ans, r - l + 1);
		}
			io.println(ans);
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
