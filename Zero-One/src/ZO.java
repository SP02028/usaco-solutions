import java.util.*;
import java.io.*;
public class ZO {

	public static void main(String[] args) {
		Kattio io =new Kattio();
		int T = io.nextInt();
		while(T-->0) {
			int n = io.nextInt();
			long x = io.nextLong();
			long y = io.nextLong();
			String a = io.next();
			String b = io.next();
			String c=xor(a,b);
			int count = 0;
			int first = -1;
			int second = -1;
			for(int i = 0; i < n;i++) {
				if(c.charAt(i)=='1') {
					count++;
					if(first==-1) {
						first = i;
					}
					else {
						second = i;
					}
				}
			}
			if(count%2==1) {
				io.println(-1);
			}
			else if(count==2) {
				if((first+1)==second) {
					io.println(Math.min(x, 2*y));
				}
				else {
					io.println(y);
				}
			}
			else {
				io.println((count/2)*y);
			}
		}
		io.close();

	}
	public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca == cb) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
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
