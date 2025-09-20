import java.util.*;
import java.io.*;
public class PTB {
static int count;
static int K;
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("paintbarn");
		int N = io.nextInt();
		K = io.nextInt();
		int[][] arr=new int[1001][1001];
		int[][] ops = new int[N][5];
		for(int i=0;i<N;i++) {
			ops[i][0] = 1;
			ops[i][1] = io.nextInt();
			ops[i][2] = io.nextInt();
			ops[i][3] = io.nextInt();
			ops[i][4] = io.nextInt();
		}
		diff(arr, ops);
		io.println(count);
		io.close();
	}
	public static int[][] diff(int[][] arr, int[][] opr) {
        int n = arr.length;
        int m = arr[0].length;

        // diff matrix of size n x m
        int[][] diff = new int[n][m];

        // apply all operations using 4-point updates
        for (int[] q : opr) {
            int v = q[0];
            int r1 = q[1], c1 = q[2], r2 = q[3], c2 = q[4];

            // top-left -> add
            diff[r1][c1] += v;
            if (c2  < m) diff[r1][c2 ] -= v; 
            if (r2  < n) diff[r2 ][c1] -= v; 
            if (r2 < n && c2 < m) diff[r2 ][c2 ] += v; 
        }

        // row-wise prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // column-wise prefix sum
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // apply diff to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] += diff[i][j];
                if(arr[i][j]==K) {
                	count++;
                }
            }
        }

        return arr;
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
