import java.io.*;
import java.util.*;

public class gcd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long tc = Long.parseLong(br.readLine());       
        for(int t =0;t<tc;t++) {
            long n = Long.parseLong(br.readLine());
            long[] a = new long[(int) (n + 2)];
            Arrays.fill(a, 1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            long[] b = new long[(int) (n + 2)];
            for (int i = 1; i <= n + 1; i++) {
                b[i] = lcm(a[i], a[i - 1]);
            }
            boolean isValid = true; 
            for (int i = 1; i <= n; i++) {
                if (gcd(b[i], b[i + 1]) != a[i]) {
                    pw.println("NO");
                    isValid = false; 
                    break;
                }
            }
            if (isValid) {
                pw.println("YES");
            }
        }       
        pw.close();
    }
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
