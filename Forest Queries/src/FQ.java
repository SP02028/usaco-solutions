import java.util.*;
import java.io.*;
public class FQ {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int N = io.nextInt();
		int Q = io.nextInt();
		int[][] forest = new int[N+1][N+1];
		int[][] prefix = new int[N+1][N+1];
 		for(int i = 0; i <N;i++ ) {
 			String line = io.next();
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) == '*') { 
					forest[i + 1][j + 1]++;
					}
			}
		}
 		/*for (int i = 1; i <= N; i++) {
 		    for (int j = 1; j <= N; j++) {
 		        System.out.print(forest[i][j]);
 		    }
 		    System.out.println();
 		}*/

 		for(int i = 1; i <=N;i++) {
 			for(int j = 1; j <=N;j++) {
 				prefix[i][j] = forest[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
 			}
 		}
 		for(int i = 0; i <Q;i++) {
 			int a = io.nextInt(); //fromrow
 			int b = io.nextInt(); //fromcol
 			int c = io.nextInt(); //torow
 			int d = io.nextInt(); //tocol
 			io.println(prefix[c][d]-prefix[a-1][d]-prefix[c][b-1]+prefix[a-1][b-1]);
 		}
 		//System.out.println("Done reading input");

 		io.close();
 		io.flush();
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
