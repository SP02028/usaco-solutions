import java.util.*;
import java.io.*;
public class RA {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int n = io.nextInt();
		int[][] customers = new int[n][3];
		for(int i = 0; i <n;i++) {
			customers[i][0] = io.nextInt();
			customers[i][1] = io.nextInt();
			customers[i][2] = i;
		}
		Arrays.sort(customers, Comparator.comparingInt(c -> c[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r[0]));
		int rooms = 0;
		int[] Allocation = new int[n];
		int last = 1;
		pq.add(new int[] {customers[0][1],last});
		Allocation[customers[0][2]] = last;
		
		for(int i = 1 ; i <n;i++) {
			int[] min = pq.peek();
			if(min[0] < customers[i][0]) {
				pq.remove();
				pq.add(new int[] {customers[i][1], min[1]});
				Allocation[customers[i][2]] = min[1];
			}
			else {
				last++;
				pq.add(new int[] {customers[i][1], last});
				Allocation[customers[i][2]] = last;

			}
			rooms = Math.max(pq.size(), rooms);
		}
		io.println(rooms);
		for(int i = 0; i<n;i++) {
			io.print(Allocation[i] + " ");
		}
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