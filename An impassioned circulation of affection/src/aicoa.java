import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
public class aicoa {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int len = io.nextInt();
		char[] arr = io.next().toCharArray();
		int q=io.nextInt();
		while(q-->0) {
			int paints = io.nextInt();
			char color = io.next().charAt(0);
			int l =0;
			int r = 0;
			int maxseg= 0;
			while(l < len && r <len) {
				while(r < len) {
					if(arr[r] != color) {
						if(paints ==0) {
							break;
						}
						paints--;
					}
					r++;
				}
				maxseg = Math.max(r-l, maxseg);
if(arr[l++]!=color) {
	paints++;
}
			}
			io.println(maxseg);
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