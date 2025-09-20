import java.util.*;
import java.io.*;
public class AC {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio(); //remember file io at the end of this one
		int n=io.nextInt();
		int k = io.nextInt();
		int[] arr = new int[n];
		for(int i =0 ; i < n;i++) {
			arr[i] = io.nextInt();
		}
		Arrays.sort(arr);
		int low = 0;
		int high = arr[n-1]-arr[0];
		//low isn't getting updated for some reason -> dumbass you didn't sort the array
		while(low<high) {
			int mid = (low+high)/2;
			if(canDivide(arr,k,  mid)) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		io.println(low);
		io.close();
	}
	public static boolean canDivide(int[] arr, int k, int mid) {
		int cows= 1;
		int reached = arr[0] +2*mid;
		for(int i = 0;i <arr.length;i++) {
			if(arr[i ] <=reached) {
				continue;
			}
			else {
				reached=arr[i] + 2*mid;
				cows++;
			}
		}
		return cows <=k;
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
