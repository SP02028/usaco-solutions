import java.io.*;
import java.util.*;

public class SIAR {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.nextInt();
		int[] x = new int[n];
        int[] y= new int[n];
        ArrayList<Integer> east = new ArrayList<>();
		ArrayList<Integer> north = new ArrayList<>();
        for (int i = 0; i < n; i++) {
			String dir = io.next();
			if (dir.equals("E")) {
				east.add(i);
			} else {
				north.add(i);
			}
			x[i] = io.nextInt();
			y[i] = io.nextInt();
		}
		// sort east cows by their y-coordinate
		east.sort(Comparator.comparingInt(i -> y[i]));
		// sort north cows by their x-coordinate
		north.sort(Comparator.comparingInt(i -> x[i]));
		boolean[] stop = new boolean[n];
		int[] stopped = new int[n];
		// array to store the earliest stop time for each cow
		int[] time = new int[n];
		Arrays.fill(time, Integer.MAX_VALUE);
		// compare each east cow with each north cow
		for (int e : east) {
			for (int no : north) {
				/*For an intersection to be valid:
				- both cows are not stopped
				 - north cow's x > east cow's x
				 - east cow's y > north cow's y
				 */
				if (!stop[e] && !stop[no] &&  x[no] > x[e] && y[e] > y[no]) {
					// calculate times to reach the intersection
					int te = x[no] - x[e];
					int tn = y[e] - y[no];
					if (te > tn) {
						// north cow stops the east cow
						if (te < time[e]) { // only stop if this is the first/earliest stop
							stop[e] = true;
							time[e] = te;
							stopped[no] += 1 + stopped[e];
						}
					} else if (tn > te) {
						// east cow stops the north cow
						if (tn < time[no]) { // only stop if this is the first/earliest stop
							stop[no] = true;
							time[no] = tn;
							stopped[e] += 1 + stopped[no];
						}
					}
					// if te == tn, both pass by without affecting each other
				}
			}
		}

		// print how many cows are stopped by every cow
		for (int i = 0; i < n; i++) {
			io.println(stopped[i]);
		}

		io.close();
	}

	// Kattio class for fast input and output
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		// Input and output as System.in and System.out 
		public Kattio() {
			this(System.in, System.out);
		}

		// Input and output streams
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}

		// Read the next token
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) {
					String line = r.readLine();
					if (line == null) return null;
					st = new StringTokenizer(line);
				}
				return st.nextToken();
			} catch (Exception e) {
				return null;
			}
		}

		// Next integer
		public int nextInt() {
			return Integer.parseInt(next());
		}

		// Next long
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
