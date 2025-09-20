import java.util.*;
import java.io.*;
public class MKCG {
	static boolean[] visited;
	static List<Integer>[][] adj;
//	static List<ArrayList<Integer>> colors;
	static int n;
	public static void main(String[] args) {
		Kattio io =new Kattio();
		n= io.nextInt();
		int m = io.nextInt();
		adj = new ArrayList[m+1][n+1];
		for (int i = 1; i <= m; i++) {
		    for (int j = 1; j <= n; j++) {
		        adj[i][j] = new ArrayList<>();
		    }
		}
		//colors = new ArrayList<ArrayList<Integer>>();
		//this wont work cause multiple colors can be assigned to the same edge
		for(int i = 0; i < m; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			int c = io.nextInt();
			//we'll construct the adj list based on color so that color[start node] = connected to nodes.
			adj[c][a].add(b);
			adj[c][b].add(a);
		//	colors.get(a).set(b, null)
		}
		int q = io.nextInt();
		for(int i = 0 ; i  < q; i++) {
			int f = io.nextInt();
			int t = io.nextInt();
			int count = 0;
			for(int j= 1; j <=m;j++) {
				visited = new boolean[n+1];
				if(dfs(f,t,j)) {
					count++;
				}
			}
			io.println(count);
		}
		io.close();
	}
	public static boolean dfs(int curr, int target, int color) {
		if(curr==target) {
			return true;
		}
		visited[curr] = true;
		for(int nbr:adj[color][curr]) {
			if(!visited[nbr]) {
				if(dfs(nbr, target, color)) {
					return true;
				}
			}
		}
		return false;
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
