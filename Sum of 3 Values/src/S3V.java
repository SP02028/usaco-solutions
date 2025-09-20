import java.util.*;
import java.io.*;
public class S3V {
static List<Pair> values;
static int N;
	public static void main(String[] args) {
		Kattio io = new Kattio();
		values = new ArrayList<>();
		N = io.nextInt();
		int target = io.nextInt();
		for (int i = 0; i < N; i++) {
			int x = io.nextInt();
			values.add(new Pair(x, i + 1));
		}
		Collections.sort(values);
		boolean printed =false;
		for(int i = 0; i<N;i++) {
			int[] res = S2V(target - values.get(i).val);
			if(res.length==2) {
				  int a = res[0];
				    int b = res[1];
				    int c = values.get(i).index;

				    if (a != b && a != c && b != c) {
				        io.println(a + " " + b + " " + c);
				        printed = true;
				        break;
				    }
			}
		}
		if(!printed) {
			io.println("IMPOSSIBLE");
		}
		io.close();
	}
	public static int[] S2V(int t){
		int left = 0;
		int right = N-1;
		while(left<right) {
			int currsum = values.get(left).val+values.get(right).val;
			if(currsum ==t) {
				return new int[]{values.get(left).index , values.get(right).index};
			}
			else if(currsum<t) {
				left++;
			}
			else {
				right--;
			}
		}
			return new int[]{-1};
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
