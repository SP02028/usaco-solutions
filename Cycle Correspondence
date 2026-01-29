import java.util.*;
import java.io.*;

public class CC {

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int K = io.nextInt();

        int[] a = new int[K];
        int[] b = new int[K];

        HashSet<Integer> set = new HashSet<>();

        int[][] indices = new int[N + 1][3];
        int[][] indices2 = new int[N + 1][3];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(indices[i], -1);
            Arrays.fill(indices2[i], -1);
        }
        for (int i = 0; i < K; i++) {
            a[i] = io.nextInt();
            set.add(a[i]);
            indices[a[i]][0] = i;
            indices2[a[i]][0] = i;
        }

        for (int i = 0; i < K; i++) {
            b[i] = io.nextInt();
            set.add(b[i]);
            indices[b[i]][1] = i;
            indices2[b[i]][1] = K - 1 - i; 
        }

        long sameOutside = N - set.size();

        int max1 = rotate(indices, K);
        int max2 = rotate(indices2, K);

        io.println(sameOutside + Math.max(max1, max2));
        io.close();
    }

    public static int rotate(int[][] indices, int K) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int val = 1; val < indices.length; val++) {
            int i = indices[val][0];
            int j = indices[val][1];

            // only consider values that appear in BOTH cycles
            if (i == -1 || j == -1) continue;

            int r = (i - j + K) % K;
            freq.put(r, freq.getOrDefault(r, 0) + 1);
        }

        int best = 0;
        for (int key : freq.keySet()) {
            best = Math.max(best, freq.get(key));
        }
        return best;
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
