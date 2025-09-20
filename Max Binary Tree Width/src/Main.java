import java.io.*;
import java.util.*;

public class Main {
	static long computeSum(long w) {
	    long sum = 0;
	    while (w > 0) {
	        sum += w;
	        w = (w + 1) / 2; 
	    }
	    return sum;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            long lo = 1, hi = n, ans = 1;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (computeSum(mid) <= n) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            out.println(ans);
        }
        out.flush();
    }
}

