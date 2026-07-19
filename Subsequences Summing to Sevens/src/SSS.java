import java.util.*;
import java.io.*;
public class SSS {
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int N = io.nextInt();
        long[] pref = new long[N+1];
        int[] a = new int[N+1];
        for(int i =1;i<N;i++){
            a[i] = io.nextInt();
        }
        a[0]=-1;
        pref[0]=-1;
        for(int i = 1; i <N;i++){
            pref[i] = a[i] + pref[i-1];
        }
        Map<Long, ArrayList<Integer>> freq = new HashMap<>();
        for(int i=1;i<=N;i++){
            pref[i] = pref[i]%7;
            if(freq.containsKey(pref[i])){
                freq.get(pref[i]).add(i);
            }
            else{
                freq.put(pref[i], new ArrayList<Integer>());
                freq.get(pref[i]).add(i);
            }
        }
       // for(long p:pref){
       //     System.out.print(p + " ");
       // }
        System.out.println();
        //find the two indices with biggest gap
        int max= -1;
        for(ArrayList<Integer> arr: freq.values()){
            int size= arr.size();
            int diff = arr.get(size-1) - arr.get(0);
            max = Math.max(max, diff);
        }
        io.println(max);
        io.close();
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
