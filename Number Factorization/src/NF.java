import java.io.*;
import java.util.*;
public class NF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());  
        for(int T=0;T<t;T++){
            long n = Long.parseLong(br.readLine().trim());
            long x = n;
            Map<Long, Long> m = new HashMap<>();
            if (x % 2 == 0) {
                while (x % 2 == 0) {
                    m.put(2L, m.getOrDefault(2L, 0L) + 1);
                    x /= 2;
                }
            }
            for (long i = 3; i * i <= x; i += 2) {
                while (x % i == 0) {
                    m.put(i, m.getOrDefault(i, 0L) + 1);
                    x /= i;
                }
            }
            if (x > 1) {
                m.put(x, m.getOrDefault(x, 0L) + 1);
            }
            long max = Long.MAX_VALUE;
            long mn = max;
            long ans = 0;
            while (mn != max - 1) {
                mn = max - 1;
                for (Map.Entry<Long, Long> entry : m.entrySet()) {
                    if (entry.getValue() != 0) {
                        mn = Math.min(mn, entry.getValue());
                    }
                }
                long ans1 = 1;
                for (Map.Entry<Long, Long> entry : m.entrySet()) {
                    if (entry.getValue() != 0) {
                        ans1 *= entry.getKey();
                        m.put(entry.getKey(), entry.getValue() - mn);
                    }
                }
                if (mn != max - 1) {
                    ans += (ans1 * mn);
                }
            }
            pw.println(ans);
        }
        pw.close();
    }
}

