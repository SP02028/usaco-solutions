import java.util.*;
import java.io.*;
public class MW {

	public static void main(String[] args) throws IOException{
		Kattio io =new Kattio();
		int N = io.nextInt();
		int K = io.nextInt();
		int[] arr=new int[N];
		TreeSet<Integer> set= new TreeSet<Integer>();
		int[] freq = new int[1000001];
		for(int i = 0; i < N;i++) {
			arr[i] = io.nextInt();
			freq[arr[i]]++;
			set.add(arr[i]);
		}
		int count =0;
		int[] temp = new int[set.size()];
		int i = 0;
		for(int s:set) {
			temp[i] = s;
			i++;
		}
		for(int j = 0; j<temp.length-1;j++) {
			if(temp[j] + K >=temp[j+1]) {
				count +=freq[temp[j]];
			//	io.println(count + ": " + temp[j]);
			}
		}
		io.println(N-count);
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
