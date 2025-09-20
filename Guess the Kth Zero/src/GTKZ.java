import java.util.*;
import java.io.*;
public class GTKZ {

	public static void main(String[] args) throws IOException{
		Kattio io=new Kattio();
		int n = io.nextInt();
		int t = io.nextInt();
		int k= io.nextInt();
		int low =1;
		int high = n;
		while(low<high) {
			int mid = (low+high)/2;
			io.println("? 1" + " " + mid);
			io.flush();
			int sum = io.nextInt();
			int numzeros = mid - sum;
			if(numzeros >=k) {
				high =mid;
			}
			else {
				low = mid+1;
			}
		}
		io.println("! " + low);
		io.flush();

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
            } catch (Exception e) { }
            return null;
        }
        
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
