import java.io.*;
import java.util.*;

public class FP {
	static int[][] cows;       
	static List<Integer>[] graph;
	static boolean[] visited;
	static int xl = Integer.MAX_VALUE;
	static int xh = Integer.MIN_VALUE;
	static int yl = Integer.MAX_VALUE;
	static int yh = Integer.MIN_VALUE;


	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int n = io.nextInt();
		int m = io.nextInt();
		visited = new boolean[n + 1];
		cows = new int[n + 1][2];  
		for (int i = 1; i <= n; i++) {
			cows[i][0] = io.nextInt();
			cows[i][1] = io.nextInt();
		}
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				int p = ((xh - xl) + (yh - yl)) * 2;
				min = Math.min(min, p);
				xl = Integer.MAX_VALUE;
				xh = Integer.MIN_VALUE;
				yl = Integer.MAX_VALUE;
				yh = Integer.MIN_VALUE;
			}
		}

		io.println(min);
		io.close();
	}
	static void dfs(int curr) {
		visited[curr] = true;
		int x = cows[curr][0];
		int y = cows[curr][1];

		xl = Math.min(xl, x);
		xh = Math.max(xh, x);
		yl = Math.min(yl, y);
		yh = Math.max(yh, y);
		for (int c : graph[curr]) {
			if (!visited[c]) {
				dfs(c);
			}
		}
	}
	//BeginCodeSnip{Kattio}
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
	//EndCodeSnip
}
