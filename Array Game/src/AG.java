import java.util.*;
import java.io.*;

public class AG {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int len = io.nextInt();
			long K = io.nextLong();
			long[] arr=new long[len];
			for(int i =0;i<len;i++) {
				arr[i] = io.nextLong();
			}
			if(K>=3) {
				io.println(0);
				continue;
			}
			Arrays.sort(arr);
			if(K==0) {
				io.println(arr[0]);
			}
			else {
				long[] diff = new long[len-1];
				for(int i =0; i <len-1;i++) {
					diff[i] = arr[i+1]-arr[i];
				}
				Arrays.sort(diff);
				if(K==1) {
					io.println(diff[0]);
				}
				else {
				    long left = 0;
				    long right = (long)1e18; // or a maximum value in arr

				    long answer = right;

				    while (left <= right) {
				        long mid = left + (right - left) / 2;
				        if (check(mid, arr, (int)K)) {
				            answer = mid;
				            right = mid - 1;
				        } else {
				            left = mid + 1;
				        }
				    }

				    io.println(Math.min(answer, arr[0]));
				}

			}
		}
		io.close();

	}
	static boolean check(long x, long[] arr, int K) {
	    Set<Long> current = new HashSet<>();
	    for (int i = 0; i < arr.length; i++) {
	        for (int j = i+1; j < arr.length; j++) {
	            long diff = Math.abs(arr[i] - arr[j]);
	            if (diff <= x) {
	            	return true;
	            }
	            current.add(diff);
	        }
	    }
	  
	    return false;
	}
	static long gcd(long a, long b) {
	    while (b != 0) {
	        long t = b;
	        b = a % b;
	        a = t;
	    }
	    return a;
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
