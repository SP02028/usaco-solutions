import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LAD {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			long a = io.nextLong();
			long b = io.nextLong();
			long k = io.nextLong();
			if (a <= k && b <= k) {
			    io.println(1);
			} else if (onemove(a,b,k)) {
			    io.println(1);
			} else {
			    io.println(2);
			}
			}
		
		io.close();
	}
	public static boolean onemove(long a, long b, long k) {
		long gc = gcd(a, b);
	    for (long i = 1; i * i <= gc; i++) {
	        if (gc % i == 0) {
	            if (a / i <= k && b / i <= k) {
	            	return true;
	            }
	            if (a / (gc/i) <= k && b / (gc/i) <= k) {
	            	return true;
	            }
	        }
	    }
	    return false;
	}
	public static long gcd(long a, long b) {
	    while (b != 0) {
	        long temp = a % b;
	        a = b;
	        b = temp;
	    }
	    return a;
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
