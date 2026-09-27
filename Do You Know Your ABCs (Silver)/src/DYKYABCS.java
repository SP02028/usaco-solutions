import java.util.*;
import java.io.*;
public class DYKYABCS {

	public static void main(String[] args) {
		Kattio io =new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int N = io.nextInt();
			List<Long> arr = new ArrayList<>();
			for(int i =0 ;i < N;i++) {
				arr.add((long) io.nextLong());
			}
			Set<Long> expanded = new HashSet<Long>();
			for(int i =0;i<N;i++) {
				expanded.add(arr.get(i));
				for(int j =0 ;j <N;j++) {
					if(arr.get(j)>arr.get(i)) {
						expanded.add(arr.get(j)-arr.get(i));
					}
				}
			}
			int answer = 0;
			 for (Long a : expanded) {
	                for (Long b : expanded) {
	                    for (Long c : expanded) {
	                        if (a <= b && b <= c) {
	                            List<Long> allNumbers = Arrays.asList(a, b, c, a + b, b + c, c + a, a + b + c);
	                            boolean works = true;
	                            for (Long x : arr) {
	                                if (!allNumbers.contains(x)) {
	                                    works = false;
	                                }
	                            }
	                            if (works) {
	                                answer++;
	                            }
	                        }
	                    }
	                }
	            
			}
			 io.println(answer);
		}
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
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
