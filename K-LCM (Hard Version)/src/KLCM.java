import java.util.*;
import java.io.*;
public class KLCM {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int n = io.nextInt();
			int k = io.nextInt();
			for(int i = 0; i <k-3;i++) {
				io.print(1 + " ");
			}
			int res = n-k+3;
			if(res%2 == 1) {
				io.print(res/2 + " ");
				io.print(res/2 + " ");
				io.print(1);
			}
			else if(res%4==0) {
				io.print(res/2 + " ");
				io.print(res/4 + " ");
				io.print(res/4);
			}
			else {
				io.print((res/2)-1 + " ");
				io.print((res/2)-1 + " ");
				io.print(2);
			}
			io.println();
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
}
