import java.util.*;
import java.io.*;
public class HS {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int N = io.nextInt();
		int K= io.nextInt();
		int[] arr = new int[N+1];
		for(int i = 0; i <N;i++) {
			arr[i] = i;
		}
		int[] diffarr = new int[N+2];
		for(int i = 0; i <K;i++) {
			int a = io.nextInt()-1;
			int b = io.nextInt()-1;
			update(diffarr, a, b, 1);
		}
		int[] prefix = new int[N];
		prefix[0] = diffarr[0];
		for (int i = 1; i < N; i++) {
		    prefix[i] = prefix[i - 1] + diffarr[i];
		}
		Arrays.sort(prefix);
		io.println(prefix[N / 2]);

		io.close();
	}
	static void update(int[] arr, int l, int r, int x) {
        arr[(int) l] = arr[(int) l] + x;
        if (r + 1 < arr.length) {
            arr[(int) (r + 1)] -= x;
        }
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
