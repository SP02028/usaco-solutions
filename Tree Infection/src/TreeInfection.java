import java.io.*;
import java.util.*;

public class TreeInfection {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while (T-- > 0) {
            int N = kattio.nextInt();
            int[] arr = new int[N + 1];
            Arrays.fill(arr, 0);

            for (int i = 1; i < N; ++i) {
                int x = kattio.nextInt();
                ++arr[--x];
            }

            List<Integer> freq = new ArrayList<>();
            for (int v : arr) if (v > 0) freq.add(v);
            freq.add(1);

            Collections.sort(freq, Collections.reverseOrder());

            int ans = 0;
            int size = freq.size();
            for (int i = 0; i < size; ++i) {
                freq.set(i, freq.get(i) - (size - i));
                ans++;
            }
            while (!freq.isEmpty() && freq.get(freq.size() - 1) <= 0)
                freq.remove(freq.size() - 1);

            Collections.sort(freq, Collections.reverseOrder());

            ans += dec(freq);

            kattio.println(ans);
        }
        kattio.close();
    }
    static int dec(List<Integer> a) {
        if (a.isEmpty()) return 0;

        int ans = 0;

        while (!a.isEmpty()) {
            int n = a.size();
            int last = 0;
            int maxVal = a.get(0);
            for (int i = 0; i < n; ++i) {
                if (a.get(i) == maxVal) last = i;
                else break;
            }

            a.set(last, a.get(last) - 1);

            for (int i = 0; i < n; ++i)
                a.set(i, a.get(i) - 1);

            ans++;
            while (!a.isEmpty() && a.get(a.size() - 1) <= 0)
                a.remove(a.size() - 1);
            a.sort(Collections.reverseOrder());
        }

        return ans;
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
    }
}
