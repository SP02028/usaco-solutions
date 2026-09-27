import java.io.*;
import java.util.*;

public class RS {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int N = kattio.nextInt();
        int m = kattio.nextInt();
        int r = kattio.nextInt();

        int[] milk = new int[N];
        for (int i = 0; i < N; i++) {
            milk[i] = kattio.nextInt();
        }
        Arrays.sort(milk); // ascending

        int[][] shops = new int[m][2]; // quantity, price
        for (int i = 0; i < m; i++) {
            shops[i][0] = kattio.nextInt();
            shops[i][1] = kattio.nextInt();
        }
        Arrays.sort(shops, (a, b) -> Integer.compare(b[1], a[1])); // decreasing price

        long[] rentals = new long[r];
        for (int i = 0; i < r; i++) {
            rentals[i] = kattio.nextLong();
        }
        Arrays.sort(rentals);
        for (int i = 0, j = r - 1; i < j; i++, j--) { // reverse to descending
            long tmp = rentals[i];
            rentals[i] = rentals[j];
            rentals[j] = tmp;
        }

        long[] maxprofit = new long[N + 1];
        int rentLimit = Math.min(N, r);
        for (int i = 1; i <= rentLimit; i++) {
            maxprofit[i] = maxprofit[i - 1] + rentals[i - 1];
        }
        for (int i = rentLimit + 1; i <= N; i++) {
            maxprofit[i] = maxprofit[i - 1];
        }

        long[] maxprofitmilk = new long[N + 1];
        long sum = 0L;          // leftover UNSOLD milk (carryover)
        int index = 0;          // shop index
        long remaining = (m > 0) ? shops[0][0] : 0L;
        long revenue = 0L;

        for (int i = 1; i <= N; i++) {
            sum += milk[N - i];     // add new cow's milk to leftover
            long currsum = sum;     // try to sell leftover + new

            while (currsum > 0 && index < m) {
                if (remaining == 0) {
                    index++;
                    if (index >= m) break;
                    remaining = shops[index][0];
                    continue;
                }

                long sold = Math.min(currsum, remaining);
                revenue += sold * (long) shops[index][1];
                currsum -= sold;
                remaining -= sold;
            }

            sum = currsum;          // IMPORTANT: keep only UNSOLD milk
            maxprofitmilk[i] = revenue;
        }

        long max = 0L;
        for (int i = 0; i <= N; i++) {
            long rent = maxprofit[i];
            long milks = maxprofitmilk[N - i];
            max = Math.max(rent + milks, max);
        }

        kattio.println(max);
        kattio.close();
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
