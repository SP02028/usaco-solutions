import java.io.*;
import java.util.*;

public class FP2 {
    public static void main(String[] args) {
        Kattio kattio = new Kattio("fairphoto");

        int N = kattio.nextInt();

        int[] positions = new int[N];
        int[] types = new int[N];

        // Read each cow's position and breed.
        // Encode G = -1 and H = +1 (either sign works - what matters is that
        // they're opposites, since a fair window is one where these cancel to 0).
        for (int i = 0; i < N; i++) {
            positions[i] = kattio.nextInt();
            String type = kattio.next();
            if (type.equals("G")) types[i] = -1;
            else types[i] = 1;
        }

        // Cows aren't given in position order, so sort indices by position.
        // We need position order because "contiguous interval of fence" means
        // a contiguous run of cows once they're arranged left-to-right.
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);

        // first[sum] = the earliest position where running prefix sum "sum" occurred.
        // A subarray sums to zero exactly when two prefix sums are equal, so storing
        // the EARLIEST occurrence lets us grab the longest possible zero-sum window
        // the instant a sum repeats - O(1) lookup instead of re-scanning.
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, positions[idx[0]]); // prefix sum 0 "starts" at the first cow's position

        int pref = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            pref += types[idx[i]];

            // This sum has occurred before -> everything between that earlier point
            // and here has an equal count of G and H -> a valid fair photo.
            if (first.containsKey(pref)) {
                ans = Math.max(ans, positions[idx[i]] - first.get(pref));
            }

            // Record the earliest left boundary for this prefix sum, so future
            // occurrences can reference back to it. Only the FIRST occurrence
            // matters, since it gives the longest possible window later.
            if (i + 1 < N && !first.containsKey(pref)) {
                first.put(pref, positions[idx[i + 1]]);
            }
        }

        // --- The case the hashmap approach can't see ---
        // A run of consecutive same-breed cows is ALSO a valid fair photo,
        // since with only one breed present there's nothing to balance against.
        // The prefix sum climbs monotonically through a pure run and never
        // repeats, so the loop above silently misses this case entirely.
        int i = 0;
        while (i < N) {
            int j = i;
            while (j + 1 < N && types[idx[j + 1]] == types[idx[i]]) {
                j++;
            }
            ans = Math.max(ans, positions[idx[j]] - positions[idx[i]]);
            i = j + 1;
        }

        kattio.println(ans);
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
