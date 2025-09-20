import java.util.*;
import java.io.*;
public class CDS {
	static int[] list;
	static int n;
	static int maxT;
	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		n = io.nextInt();
		maxT = io.nextInt();
		list = new int[n];
		for(int i = 0; i <n;i++) {
			list[i] = io.nextInt();
		}
		//test every value, but do this smartly - if a value doesn't work
		//nothing greater than it works.
		//we can do this with just basic binary search
		int min = 1;
		int max = n;
		while(min !=max) {
			int  mid = (min+max)/2;
			if(possible(mid)) { //check if median number is possible
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		io.print(min);
		io.close();
	}
	// method to determine if a certain K is possible
	public static boolean possible(int K) {
		int last = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < n;i++) {
			if(q.size()==K) {
				//if theres K values in the queue, delete min val
				last = q.poll();
			}
			if(last + list[i] > maxT) {
				return false;
			}
			q.add(last+ list[i]); //simulating that "compounding times to make sure none exceed" thing you were trying to do in the sample tc.
		}
		return true;
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
