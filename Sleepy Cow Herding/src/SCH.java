import java.io.*;
import java.util.*;

public class SCH {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] cows = new int[n];
        for(int i = 0; i < n; i++) {
            cows[i] = io.nextInt();
        }
        Arrays.sort(cows);
        // Min calculation
        int maxinrange = 0;
        int l = 0;        
        // Sliding window to find max cows in any window of size n
        for(int r = 0; r < n; r++) {
            while(cows[r] - cows[l] >= n) {
                l++;
            }
            maxinrange = Math.max(maxinrange, r - l + 1);
        }       
        // Check for special case after the sliding window
        boolean edge = false;
        if (n > 1) {
            if ((cows[n-2] - cows[0] + 1 == n-1 && cows[n-1] - cows[n-2] > 2) ||
                (cows[n-1] - cows[1] + 1 == n-1 && cows[1] - cows[0] > 2)) {
                edge = true;
            }
        }      
        int min;
        if (edge) {
            min = 2;  // Special case always needs 2 moves
        } else {
            min = n - maxinrange;
        }
        
        io.println(min);       
        // Max calculation
        int spaces = cows[n-1] - cows[0] + 1 - n;
        int gapf = cows[1] - cows[0] - 1;
        int gapl = cows[n-1] - cows[n-2] - 1;
        int max = Math.max(spaces - gapf, spaces - gapl);
        
        io.println(max);
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