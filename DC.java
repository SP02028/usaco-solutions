import java.util.*;
import java.io.*;

public class DC {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("diamond");
        int N = io.nextInt();
        int K = io.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = io.nextInt();

        Arrays.sort(arr);
        int[] len = new int[N];
        int right = 0;

        for (int left = 0; left < N; left++) {
            while (right < N && arr[right] - arr[left] <= K) {
                right++;
            }
            len[left] = right - left;
        }
        int[] maxs = new int[N + 1];//If I’m only allowed to start at index i or later, what’s the biggest group I can make?
        for (int i = N - 1; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i + 1], len[i]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int j = i + len[i];
            ans = Math.max(ans, len[i] + maxs[j]);
        }

        io.println(ans);
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

