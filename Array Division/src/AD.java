import java.util.*;
import java.io.*;

public class AD {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int k = io.nextInt();
        long[] arr = new long[n];  // Changed to long array
        for(int i = 0; i < n; i++) {
            arr[i] = io.nextLong();  // Changed to nextLong()
        }
        
        // Set up binary search bounds
        long left = 0;    // minimum possible answer
        long right = 0;   // maximum possible answer
        
        for(int i = 0; i < n; i++) {
            left = Math.max(left, arr[i]);  // at least the largest element
            right += arr[i];                // at most the sum of all elements
        }
        
        // Binary search for the minimum feasible maximum sum
        while(left < right) {  // Changed condition to l < r
            long mid = (left + right) / 2;  // Simplified mid calculation
            
            if(canDivide(arr, k, mid)) {
                // mid is feasible, try to find something smaller
                right = mid;  // Changed to right = mid (not mid - 1)
            } else {
                // mid is not feasible, need larger limit
                left = mid + 1;
            }
        }
        
        io.println(left);  // Print left (which equals right at end)
        io.close();
    }
    
    // Check if we can divide array into at most k subarrays
    // such that each subarray sum is at most maxSum
    static boolean canDivide(long[] arr, int k, long maxSum) {  // Changed to long[] arr
        int subarrays = 0;      // Changed: start with 0, count as we go
        long currentSum = 0;    // sum of current subarray
        
        for(long x : arr) {  // Enhanced for loop
            if(x > maxSum) {  // Early termination if single element > maxSum
                return false;
            }
            
            if(currentSum + x > maxSum) {
                // Can't add to current subarray, start a new one
                subarrays++;
                currentSum = 0;  // Reset current sum
            }
            currentSum += x;  // Add element to current subarray
        }
        
        if(currentSum > 0) {  // Count the last subarray if it has elements
            subarrays++;
        }
        
        return subarrays <= k;  // we used at most k subarrays
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
