import java.util.*;
import java.io.*;
public class MBM {

	public static void main(String[] args) {
		Kattio io =new Kattio();
		int n =io.nextInt();
		int k = io.nextInt();
		int[][] arr=new int[n][n];
		if(k>n*n) {
			io.println(-1);
			io.close();
			return;
		}
		else {
			for(int i = 0; i < n; i ++) {
				for(int j = i; j < n;j++) {
					if(i==j && k>0) {
						arr[i][j]=1;
						k--;
					}
					if(i<j && k>=2) {
						arr[i][j] = 1;
						arr[j][i] = 1;
						k-=2;
					}
				}
			}
		}
		for(int[] ar : arr) {
			for(int a: ar) {
				io.print(a +" ");
			}
			io.println();
		}
		io.close();
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
	        public long nextLong() { return Long.parseLong(next()); }
	        public double nextDouble() { return Double.parseDouble(next()); }
	    }
}
