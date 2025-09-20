import java.util.*;
import java.io.*;

public class DC {

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int t = io.nextInt();
		while (t-- > 0) {
			String str = io.next();
			int[] freqarr = new int[26];
			char[] arr = str.toCharArray();
			for (char c : arr) {
				freqarr[c - 'A']++;
			}
			StringBuilder sb = new StringBuilder();
			char[] needed = new char[]{'T','F','N'};
			for (char c : needed) {
				while (freqarr[c - 'A']--> 0) {
					sb.append(c);
				}
			}
			for (int i = 0; i < 26; i++) {
				char c = (char) (i + 'A');
				if (c != 'T' && c != 'F' && c != 'N') {
					while (freqarr[i]--> 0) {
						sb.append(c);
					}
				}
			}

			io.println(sb.toString());
		}
		io.close();
	}

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		public Kattio() {
			this(System.in, System.out);
		}

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
			} catch (Exception e) {
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
