import java.util.*;
import java.io.*;

public class DAK {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            char[] arr = br.readLine().toCharArray();
            HashMap<String, Integer> map = new HashMap<>();
            int ds = 0;
            int ks = 0;
            for (char c : arr) {
                if (c == 'D') {
                    ds++;
                } else {
                    ks++;
                }
                int D = ds;
                int K = ks;
                if (D == 0) {
                    K = 1;
                } else if (K == 0) {
                    D = 1;
                } else {
                    int gcd = gcd(D, K);
                    D /= gcd;
                    K /= gcd;
                }
                String key = D + ":" + K;
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
                pw.print(map.get(key) + " ");
            }
            pw.println();
        }
        pw.close();
    }

    public static int gcd(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}

