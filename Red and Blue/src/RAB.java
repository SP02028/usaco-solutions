import java.util.*;
import java.io.*;
public class RAB {

	public static void main(String[] args) throws IOException{
	Kattio io = new Kattio();
	int T = io.nextInt();
	while(T-->0) {
		int redsize = io.nextInt();
		int[] red = new int[redsize+1];
		for(int i =1;i <=redsize;i++) {
			red[i] = io.nextInt();
		}
		int bluesize = io.nextInt();
		int[] blue = new int[bluesize+1];
		for(int i =1;i <=bluesize;i++) {
			blue[i] =io.nextInt();
		}
		int[] redprefix = new int[redsize+1];
		int maxred = 0;
		for(int i = 1; i<=redsize;i++) {
			redprefix[i] = redprefix[i-1] + red[i];
			maxred = Math.max(maxred, redprefix[i]);
		}
		int[] blueprefix = new int[bluesize+1];
		int maxblue = 0;
		for(int i = 1; i<=bluesize;i++) {
			blueprefix[i] = blueprefix[i-1] + blue[i];
			maxblue = Math.max(maxblue, blueprefix[i]);
		}
		io.println(maxred+maxblue);
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
