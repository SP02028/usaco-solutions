import java.util.*;
import java.io.*;
public class CN {

	public static void main(String[] args) {
		Kattio io=new Kattio();
		int cities = io.nextInt();
		int towers= io.nextInt();
		long[] c= new long[cities];
		for(int i = 0; i <cities;i++) {
			c[i] = io.nextLong();
		}
		long[] t = new long[towers];
		for(int i =0;i<towers;i++) {
			t[i] = io.nextLong();
		}
		long minR = 0;
		for (int i = 0; i < cities; i++) {
		int right= bins(t, c[i]);
		long rdist =0 ;
		long ldist = 0;
		if (right < t.length){
	        rdist = t[right] - c[i];
		}
	    else {
	        rdist = Long.MAX_VALUE;
	    }
	    if (right > 0) {
	        ldist = c[i] - t[right-1];
	    }
	    else {
	        ldist = Long.MAX_VALUE;
	    }
	    minR = Math.max(minR, Math.min(ldist, rdist));
		}
		io.println(minR);
		io.close();
	}
	static int bins(long[] towers, long value) {
		int low = 0, high = towers.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (towers[mid] >= value) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
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
