import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class DS {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int T = io.nextInt();
		while(T-->0) {
		long n =io.nextLong();
		String str = io.next();
		long ans = 0;
		for(long i =0; i <str.length();i++) {
			int[] freq = new int[10];
			long distinct = 0;
			long max_freq = 0;
			for(long j = i; j <str.length() && (++freq[str.charAt((int) j)-'0'])<=10;j++) {
				max_freq = Math.max(max_freq, freq[str.charAt((int) j)-'0']);
			
			if(freq[str.charAt((int) j)-'0']==1) {
				distinct++;
			}
			if(distinct>=max_freq) {
				ans++;
			}
			}
		}
		io.println(ans);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
