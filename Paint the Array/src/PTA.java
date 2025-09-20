import java.util.*;
import java.io.*;

public class PTA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);       
        int t = Integer.parseInt(br.readLine());       
        for (int tc = 0; tc < t; tc++) {
            int len = Integer.parseInt(br.readLine());
            long[] arr = new long[len];
            StringTokenizer st = new StringTokenizer(br.readLine());           
            for (int i = 0; i < len; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            List<Long> odds = new ArrayList<>();
            List<Long> evens = new ArrayList<>();            
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    evens.add(arr[i]);
                } else {
                    odds.add(arr[i]);
                }
            }           
            long gcdodd = odds.get(0);
            for (long num : odds) {
                gcdodd = gcd(gcdodd, num);
            }
            
            long gcdeven = evens.get(0);
            for (long num : evens) {
                gcdeven = gcd(gcdeven, num);
            }
     long ans = 0;
            boolean found = false;           
            for (long f : getfactors(gcdodd)) {
                boolean valid = true;
                for (long num : evens) {
                    if (num % f == 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans = f;
                    found = true;
                    break;
                }
            }          
            if (!found) {
                for (long f : getfactors(gcdeven)) {
                    boolean valid = true;
                    for (long num : odds) {
                        if (num % f == 0) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        ans = f;
                        break;
                    }
                }
            }         
            pw.println(ans);
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
    public static List<Long> getfactors(long num) {
        List<Long> factors = new ArrayList<>();
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                if (i != num / i) {
                    factors.add(num / i);
                }
            }
        }
        Collections.sort(factors, Collections.reverseOrder()); 
        return factors;
    }
}