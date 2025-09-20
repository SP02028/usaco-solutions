import java.util.*;
import java.io.*;
public class NG {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int N = io.nextInt();
		int maxdiff = io.nextInt();
		int[] arr = new int[N];
		for(int i =0; i <N;i++) {
			arr[i] = io.nextInt();
		}
		for(int i = 0;i < N-1;i++) {
			if(arr[i+1]<arr[i]-maxdiff) {
				arr[i+1] = arr[i]-maxdiff;
			}
		}
		for(int i = N-1; i >0;i--) {
			 if(arr[i-1]<arr[i]-maxdiff) {
				arr[i-1] = arr[i]- maxdiff;
			}
			}
		for(int i : arr) {
			io.print(i +" ");
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
