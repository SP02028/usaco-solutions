import java.util.*;
import java.io.*;
public class M {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int count=1;
	public static void main(String[] args) throws IOException{
		Kattio io =new Kattio("moocast");
		int N = io.nextInt();
		int[][] cows = new int[N][2];
		int[] powers = new int[N];
		visited = new boolean[N];
		adj = new ArrayList<>();
		for(int i = 0;i<N;i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int i = 0; i <N;i++) {
			int x = io.nextInt();
			int y = io.nextInt();
			int p = io.nextInt();
			powers[i] = p;
			cows[i][0] = x;
			cows[i][1] = y;
		}
		for(int i = 0;i<N;i++) {
			double power = powers[i];
			for(int j =0;j<N;j++) {
				if(dist(cows[i][0], cows[i][1], cows[j][0], cows[j][1])<=power) {
				adj.get(i).add(j);	
				}
			}
		}
		int maxcount = -1;
		for(int i = 0; i <N;i++) {
			dfs(i);
			maxcount = Math.max(maxcount, count);
			Arrays.fill(visited, false);
			count = 1;
		}
		io.println(maxcount);
		io.close();
	}
	public static void dfs(int s) {
		if(visited[s]) {
			return;
		}
		visited[s] = true;
		for(int nbr : adj.get(s)) {
			if(!visited[nbr]) {
				count++;
			dfs(nbr);
			}
		}
	}
	public static double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
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
