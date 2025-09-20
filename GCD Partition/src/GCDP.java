import java.util.*;
import java.io.*;

public class GCDP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[len];
            long sum = 0;
            for (int i = 0; i < len; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                sum += arr[i];
            }
            
            long max = 0;
            long leftSum = 0;
            for (int i = 0; i < len - 1; i++) {
                leftSum += arr[i];
                long rightSum = sum - leftSum;
                max = Math.max(max, gcd(leftSum, rightSum));
            }

            pw.println(max);
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
}