import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FWM {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();

        int N = kattio.nextInt();
        int a = kattio.nextInt();
        int b = kattio.nextInt();
        int k = kattio.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int temp = kattio.nextInt();
            temp %= (a + b);
            if (temp == 0) temp += (a + b);
            arr[i] = ((temp + a - 1) / a) - 1;
        }

        Arrays.sort(arr, 1, N + 1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (k - arr[i] < 0) break;
            k -= arr[i];
            count++;
        }

        kattio.println(count);
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            super(System.out);
            r = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() { return Integer.parseInt(next()); }
    }
}
