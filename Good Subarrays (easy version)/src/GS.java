import java.util.*;
import java.io.*;
public class GS {

	public static void main(String[] args) throws IOException{
		Kattio io =new Kattio();
		long t = io.nextLong();
		while(t-->0) {
			long len = io.nextLong();
			long[] arr =new long[(int) (len+1)];
			for(long i = 0; i < len;i++) {
				arr[(int) (i+1)] = io.nextLong();
			}
			long min = 1;
			long ans = 0;
			for(int r = 1; r <=len;r++) {
				min = Math.max(min, r-arr[r]+1);
				ans+=(r-min+1);
			}
			io.println(ans);
		}
		io.close();
	}
	public static boolean valid(int[] arr, int l, int r) {
		int p = 1;
		for(int i =l;i <=r;i++) {
			if(arr[i]<p) {
				return false;
			}
			p++;
		}
		return true;
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

	        public long nextLong() {
	            return Long.parseLong(next());
	        }

	        public double nextDouble() {
	            return Double.parseDouble(next());
	        }
	    }
}
