import java.util.*;
import java.io.*;
public class LGAMS {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int size = io.nextInt();
		int queries = io.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i <size;i++) {
			arr[i] = io.nextInt();
		}
		int[] diff=new int[size+2];
		for(int i = 0; i <queries;i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			update(diff, a, b, 1);
		}
		int[] prefix = new int[size+1];
		for(int i =1;i <size+1;i++) {
			prefix[i] = prefix[i-1]+diff[i];
		}
		Arrays.sort(prefix);
		Arrays.sort(arr);
		int sum = 0;
		for(int i =0;i<size;i++) {
			sum += arr[i] * prefix[i+1];
		}
		io.println(sum);
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
