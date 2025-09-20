import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SSI {

	public static void main(String[] args) {
		Kattio io= new Kattio();
		int N = io.nextInt();
		int k= io.nextInt();
		int[] arr=new int[N];
		for(int i = 0;i<N;i++) {
			arr[i]= io.nextInt();
			
		}
		// TODO Auto-generated method stub
		int left =0;
		long sum =0;
		int count =0;
		int right;
		for( right = 0;right<N;right++) {
			sum+=arr[right];		
		while(sum>k) {
			sum -=arr[left];
			left++;
		}
		if(sum==k) {
			count++;
		}
		}
		io.println(count);
		io.close();
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
