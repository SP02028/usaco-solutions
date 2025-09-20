import java.util.*;
import java.io.*;

public class mooloo {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        long n = Long.parseLong(st.nextToken()); 
        long m = Long.parseLong(st.nextToken()); 
        long[] days = new long[(int) n];
        StringTokenizer t = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Long.parseLong(t.nextToken());
        }
        long ans = m + 1;
        for (int i = 1; i < n; i++) {
            ans += Math.min(m + 1, days[i] - days[i - 1]);
        }
        
        pw.println(ans);
        pw.close();
    }
   
}
