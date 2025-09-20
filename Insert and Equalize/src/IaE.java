import java.io.*;
import java.util.*;
public class IaE{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];     
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }        
            long g = 0;
            for (int i = 0; i < n - 1; i++) {
                g = gcd(g, a[i + 1] - a[i]);
            }
            g = Math.max(g, 1L);
             Arrays.sort(a);           
            int j = n - 1;
            long res = a[n - 1];
          while (true) {
                while (j >= 0 && a[j] > res) {
                    j--;
                }
                if (j < 0 || a[j] != res) {
                    break;
                }
                res -= g;
            }
     long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }
         long ans = (a[n - 1] * (n + 1L) - (sum + res)) / g;
            pw.println(ans);
        }    
        pw.close();
    }
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


