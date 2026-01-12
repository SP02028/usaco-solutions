//Problem: Closing the Farm
import java.io.*;
import java.util.*;

public class CTF {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static boolean[] closed;
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("closing");
        int nodes = io.nextInt();
        int edges = io.nextInt();

        adj = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < edges; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        closed = new boolean[nodes];
        visited = new boolean[nodes];
        int[] closeOrder = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            closeOrder[i] = io.nextInt() - 1;
        }
        dfs(0);
        io.println(connected(visited));
        Arrays.fill(visited, false);
      for(int i =0 ;i <nodes-1;i++) {
    	  closed[closeOrder[i]] = true;
    	  dfs(closeOrder[i+1]);
    	  io.println(connected(visited));
          Arrays.fill(visited, false);
      }
      io.close();
    }

    static void dfs(int s) {
        if (visited[s]) {
        	return;
        }
       
        visited[s] = true;
        for (int u : adj.get(s)) {
            if ( !visited[u] && !closed[u]) {
            	dfs(u);
            }
        }
    }
    public static String connected (boolean[] visited) {
    	for(int i = 0; i <visited.length;i++) {
    		if(!closed[i]&& visited[i]==false) {
    			return "NO";
    		}
    	}
    	return "YES";
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

