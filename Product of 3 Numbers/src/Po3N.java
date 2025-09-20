import java.io.*;
import java.util.*;

public class Po3N {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            int a = leastdiv(num, -1);
            if (a == -1) {
                pw.println("NO");
                continue;
            }
            int b = leastdiv(num / a, a);
            if (b == -1) {
                pw.println("NO");
                continue;
            }
            int c = (num / a) / b;
            if (c == a || c == b || c == 1) {
                pw.println("NO");
            } else {
                pw.println("YES");
                pw.println(a + " " + b + " " + c);
            }
        }
        pw.close();
    }
    public static int leastdiv(int n, int exclude) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0 && i != exclude) {
                return i;
            }
        }
        return -1;
    }
}

