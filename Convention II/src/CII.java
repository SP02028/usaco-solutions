import java.util.*;
import java.io.*;
public class CII {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int n = io.nextInt();
		int[][] arr = new int[n][3];
 		for(int i = 1; i <=n;i++) {
			int seniority = i;
			int start = io.nextInt();
			int time = io.nextInt();
			arr[i-1][0] = seniority;
			arr[i-1][1] = start;
			arr[i-1][2] = time;
		}
 		int[] wait = new int[n];
		Arrays.sort(arr, Comparator.comparingInt(c -> c[1]));
		//int[][] inpq = new int[n][3];
		int pointer  = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c[0]));
		int end = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
		    // Add arrivals at time i
		    while (pointer < n && arr[pointer][1] == i) {
		        pq.add(arr[pointer]);
		        pointer++;
		    }
		    if (i >= end && !pq.isEmpty()) {
		        int[] temp = pq.poll();   // cow with smallest seniority
		        int starteat = Math.max(i, temp[1]);
		        int waitTime = starteat - temp[1];
		        wait[temp[0] - 1] = waitTime;

		        end = starteat + temp[2];  // set finish time
		    }
		    // Break if all cows processed
		    if (pointer == n && pq.isEmpty()) {
		        break;
		    }
		}

		Arrays.sort(wait);
		io.println(wait[n-1]);
		io.close();
	}

}
class Kattio extends PrintWriter {
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
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}