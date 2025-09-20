import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
public class S2V {

	public static void main(String[] args) {
		Kattio io=new Kattio();
		int N = io.nextInt();
		int t = io.nextInt();
		List<Pair> values = new ArrayList<>();
		// append the element and its index
		for (int i = 0; i < N; i++) {
			int x = io.nextInt();
			values.add(new Pair(x, i + 1));
		}

		Collections.sort(values);
		int left = 0;
		int right = N-1;
		boolean printed=false;
		while(left<right) {
			int currsum = values.get(left).val+values.get(right).val;
			if(currsum ==t) {
				io.print (values.get(left).index + " ");
				io.println(values.get(right).index);
				printed = true;
				break;
			}
			else if(currsum<t) {
				left++;
			}
			else {
				right--;
			}
		}
		if(!printed) {
			io.println("IMPOSSIBLE");
		}
		io.close();
	}
	static class Pair implements Comparable<Pair> {
		int val, index;

		public Pair(int x, int y) {
			this.val = x;
			this.index = y;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.val, o.val);
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
