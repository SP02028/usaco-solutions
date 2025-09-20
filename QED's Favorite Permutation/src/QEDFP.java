import java.util.*;
import java.io.*;
public class QEDFP {
/*The difference array is used to track which parts of the array need movement,
and s tells us which parts allow movement.

We only care about boundaries that are NOT allowed to be crossed,
but where some movement must happen.*/
	public static void main(String[] args) {
		Kattio io=new Kattio();
		int t= io.nextInt();
		while(t-->0) {
			int n = io.nextInt();
			int q = io.nextInt();
			int[] perm = new int[n];
			for(int i =0;i<n;i++) {
				perm[i]=io.nextInt();
			}
			for(int i=0;i<n;i++) {
				perm[i]--; //shifts down to 0 based indices
			}
			int[] invperm = new int[n];
			for(int i = 0; i <n;i++) {
				invperm[perm[i]] = i; //store where value i currently is in the array
			}
			int[] diffarr= new int[n];
			for(int i =0 ;i <n;i++) { //when swapping, how many values will pass through each position
				diffarr[Math.min(i,  invperm[i])]++;
				diffarr[Math.max(i, invperm[i])]--;
			}
			for(int i =1;i<n;i++) {
				diffarr[i] +=diffarr[i-1]; //makes arr cumulative
			}
			String s = io.next();
			HashSet<Integer> bad = new HashSet<Integer>();
			for(int i = 0; i < n-1; i++) {
				if(s.charAt(i)=='L' &&s.charAt(i+1)=='R' && diffarr[i]!=0) {
					bad.add(i);
				}
			} //point must move but cant -> store points
			while(q-->0) {
				int x = io.nextInt();
				x--;
				if(s.charAt(x)=='L') {
					s = s.substring(0, x) + 'R' + s.substring(x+1);
				}
				else {
					s = s.substring(0, x) + 'L' + s.substring(x+1);
				}
				if(s.charAt(x-1)=='L'&& s.charAt(x)=='R'&& diffarr[x-1]!=0) {
					bad.add(x-1);
				}else {
					bad.remove(x-1);
				}
				if(s.charAt(x)=='L'&&s.charAt(x+1)=='R'&& diffarr[x]!=0) {
					bad.add(x);
				}
				else {
					bad.remove(x);
				}
				if(bad.size()>0) {
					io.println("NO");
				}else {
					io.println("YES");
				}
			}
			}
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
