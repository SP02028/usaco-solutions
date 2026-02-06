import java.util.*;
import java.io.*;
public class LL {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio("lemonade");
		long N = io.nextLong();
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<N;i++) {
			pq.add(io.nextLong());
		}
		while(pq.peek()!=null && pq.peek()>=N-pq.size()) {
			pq.poll();
		}
		io.print(N-pq.size());
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
