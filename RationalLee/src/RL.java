import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
public class RL {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int T= io.nextInt();
		while(T-->0) {
			int n = io.nextInt();
			int k = io.nextInt();
			int[] arr = new int[n];
			for(int i =0 ; i < n;i++) {
				arr[i] = io.nextInt();
				}
			int[] w = new int[k];
			int num = 0;
			for(int i = 0; i < k ;i++) {
				w[i] = io.nextInt();
				if(w[i]==1) {
					num++;
				}
			}
			Arrays.sort(arr);
			Arrays.sort(w);
			long count = 0;
			for(int i = n-num; i <n;i++) {
				count +=2*arr[i];
			}
			for(int i = n-num-1;i >=n-k;i--) {
				count +=arr[i];
			}
			for(int i = 0; i < k-num;i++) {
				count +=arr[i];
			}
			io.println(count);
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
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
