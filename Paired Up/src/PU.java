import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
public class PU {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int N = io.nextInt();
		int[][] arr = new int[N][2];
		for(int i = 0; i <N;i++) {
			int count = io.nextInt();
			int val = io.nextInt();
			arr[i][0] = val;
			arr[i][1] = count;
		}
		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
		int time = -1;
		int left = 0;
		int right = N-1;
		while(left <right) {
			int sum = arr[left][0]+arr[right][0];
			arr[left][1]--;
			arr[right][1]--;
			if(arr[left][1]==0) {
				left++;
			}
			if(arr[right][1]==0) {
				right--;
			}
			time=Math.max(sum, time);
		}
		io.println(time);
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
