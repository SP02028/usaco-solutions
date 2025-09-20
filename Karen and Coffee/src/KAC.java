import java.util.*;
import java.io.*;
public class KAC {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.nextInt();
		int k = io.nextInt();
		int q = io.nextInt();
		int[] arr = new int[200002];
		for(int i = 0; i <n;i++) { //using a difference array, compute how many times each num shows in range
			int a = io.nextInt();
			int b = io.nextInt();
			update(arr, a, b, 1);
		}
		int[] pref = new int[200001]; //calc prefix sum of difference array
		for(int i = 1; i <200001;i++) {
			pref[i] = pref[i-1]+arr[i];
		} 
		int[] ok = new int[200001];//store how many are >k
		for(int i =1;i <200001;i++) {
			if(pref[i]>=k) {
				ok[i]= 1;
			}
		}
		int[] pref2 = new int[200001]; //take the prefix sum of the >k array
		for(int i = 1; i <200001;i++) {
			pref2[i] = pref2[i-1]+ok[i];
		}
		for(int i = 0; i <q;i++) { //retrieve # that are ok in O(1) for each query
			int a = io.nextInt();
			int b = io.nextInt();
			int count = 0;
			
			io.println(pref2[b]-pref2[a-1]);
		}
		io.close();
	}
	static void update(int[] arr, int l, int r, int x) {
        arr[(int) l] = arr[(int) l] + x;
        if (r + 1 < arr.length) {
            arr[(int) (r + 1)] -= x;
        }
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
