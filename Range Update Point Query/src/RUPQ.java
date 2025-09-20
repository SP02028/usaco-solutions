import java.util.*;
import java.io.*;
public class RUPQ {

	public static void main(String[] args) throws IOException{
		Kattio io =new Kattio();
		int t = io.nextInt();
		while(t-->0) {
			int n = io.nextInt();
			int q = io.nextInt();
			int[] arr = new int[n+1];
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			TreeSet<Integer> s = new TreeSet<Integer>();
			s.add(Integer.MAX_VALUE);
			for(int i =1; i <=n;i++) {
				arr[i] = io.nextInt();
				if(Integer.toString(arr[i]).length()>1){
					m.put(i, arr[i]);
					s.add(i);
				}
			}
			while(q-->0) {
				int type = io.nextInt();
				if(type==1) {
					int l = io.nextInt();
					int r = io.nextInt();
					while(s.ceiling(l)<=r) {
						int x=s.ceiling(l);
						s.remove(x);
						l=x+1;
						arr[x] = digitsum(arr[x]);
						if(arr[x]>=10) {
							s.add(x);
						}
					}
				}
				else {
					int x= io.nextInt();
					io.println(arr[x]);
				}
			}
		}
		io.close();
	}
	public static int digitsum (int n) {
		String num = Integer.toString(n);
		int sum = 0;
		for(int i = 0 ; i < num.length();i++) {
			sum+=num.charAt(i)-'0';
		}
		return sum;
	}
	static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(r.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
