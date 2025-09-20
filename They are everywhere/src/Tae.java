import java.util.*;
import java.io.*;
public class Tae {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int len = io.nextInt();
		char[] str = io.next().toCharArray();
		HashSet<Character> set = new HashSet<>();
		for(char c:str) {
			set.add(c);
		}
		HashMap<Character, Integer> freq = new HashMap<>();
		int num = set.size();
		int left  = 0;
		int have = 0;
		int minlen = str.length;
		for(int right = 0;right<len;right++) {
			 char c = str[right];
			    freq.put(c, freq.getOrDefault(c, 0) + 1);
			    if (freq.get(c) == 1) {
			        have++;
			    }
			    while (have == num) {
			        minlen = Math.min(minlen, right - left + 1);

			        char leftChar = str[left];
			        freq.put(leftChar, freq.get(leftChar) - 1);
			        if (freq.get(leftChar) == 0) {
			            have--;
			        }
			        left++;
			    }
		}
	
		io.println(minlen);
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
