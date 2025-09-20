import java.util.*;
import java.io.*;

public class STTPOT {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] a = new int[n];
        HashMap<Integer,Integer> c = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
            c.put(a[i], c.getOrDefault(a[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            for (int j = 0; j < 31; j++) {
                int x = (1 << j) - a[i];
                if (c.containsKey(x) && (c.get(x) > 1 || (c.get(x) == 1 && x != a[i]))) {
                    ok = true;
                }
            }
            if (!ok) {
            	ans++;
            }
        }
        io.println(ans);
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
	//EndCodeSnip
}
