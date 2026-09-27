import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TrailingLoves {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
      long N = kattio.nextLong();
      long b = kattio.nextLong();
        //prime factorize b
        //for each prime factor of b find the power in the factorial
        // take min power
    List<long[]> factors = primefactorize(b);
 //   System.out.println("Prime Factors: " + factors);
    long minpower = Long.MAX_VALUE;
        for (long[] factor : factors) {
            long power = factor[0];
            long count = factor[1];
        //   System.out.println("Factor: " + power + ", Count: " + count + ", Largest Power: " + largestPower(N, power));
            minpower = Math.min(minpower, largestPower(N, power) / count);
        }
kattio.println(minpower);
    //    System.out.println("Current MinPower: " + minpower);
        kattio.close();
    }
    public static long largestPower(long n, long p) {
        long result = 0;
        while (n > 0) {
            n /= p;
            result += n;
        }
        return result;
    }

    static List<long[]> primefactorize(long b) {
    List<long[]> factors = new ArrayList<>();
    for (long i = 2; i * i <= b; i++) {
        int count = 0;
        while (b % i == 0) {
            count++;
            b /= i;
        }
        if (count > 0) {
            factors.add(new long[]{i, count});
        }
    }
    if (b > 1) {
        factors.add(new long[]{b, 1});
    }
    return factors;
}

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
