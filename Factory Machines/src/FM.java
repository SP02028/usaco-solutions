import java.util.*;
import java.io.*;

public class FM {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int machines = io.nextInt();
        long products = io.nextLong();
        
        int[] arr = new int[machines];
        for(int i = 0; i < machines; i++) {
            arr[i] = io.nextInt();
        }
        long hi = (long)1e18;
        long lo = 1;       
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2; 
            if(total(arr, mid) < products) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        io.println(lo);
        io.close();
    }
    
    public static long total(int[] machines, long time) {
        long count = 0; 
        for(int machineTime : machines) {
            count += time / machineTime;
            if(count >= 2e9) return (long)2e9;
        }
        return count;
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
