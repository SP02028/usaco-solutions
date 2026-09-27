import java.io.*;
import java.util.*;

public class BA {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while (T-- > 0) {
            int N = kattio.nextInt();
            long K = kattio.nextLong();

            // basically what you're going to do is you're going to make the residue categories.
            Map<Long, ArrayList<Long>> residues = new HashMap<>();
            for (int i = 0; i < N; i++) {
                long val = kattio.nextLong();
                long res = val % K;
                residues.computeIfAbsent(res, k -> new ArrayList<>()).add(val);
            }

            // invalidity check
            int odd_count = 0;
            for (ArrayList<Long> res : residues.values()) {
                if (res.size() % 2 == 1) odd_count++;
            }

            if (odd_count > 1) {
                kattio.println(-1);
                continue;
            }

            // then sort the residue categories.
            for (long key : residues.keySet()) {
                Collections.sort(residues.get(key));
            }

            // We replace the faulty greedy pairing logic with the correct approach.
            long total = 0;

            // Iterate over all residue groups
            for (ArrayList<Long> V : residues.values()) {
                int size = V.size();

                if (size % 2 == 1) {
                    // Odd size group: Must find the minimum cost by selecting one center element.
                    total += mincostodd(V, K);
                } else {
                    // Even size group: Adjacent pairing is optimal.
                    long curr = 0;
                    for (int i = 1; i < size; i += 2) {
                        curr += (V.get(i) - V.get(i - 1)) / K;
                    }
                    //this is what my entire logic previously was
                    total += curr;
                }
            }

            kattio.println(total);

        }
        kattio.close();
    }

    // Helper function to find the minimum cost to pair up 2m elements from a sorted list V of size 2m+1, leaving one element unpaired (the center).
//I was missing this part, because my previous logic of greedily pairing only worked when the groups were all even
    private static long mincostodd(ArrayList<Long> V, long K) {
        int N = V.size();
        if (N == 1) return 0;
        // P[i]: Cost to optimally pair the first i elements V[0]...V[i-1]. (i must be even)
        long[] P = new long[N + 1];
        for (int i = 2; i <= N; i += 2) {
            P[i] = P[i - 2] + (V.get(i - 1) - V.get(i - 2)) / K;
        }
        // S[i]: Cost to optimally pair the last i elements V[N-i]...V[N-1]. (i must be even)
        long[] S = new long[N + 1];
        for (int i = 2; i <= N; i += 2) {
            S[i] = S[i - 2] + (V.get(N - i + 1) - V.get(N - i)) / K;
        }
        long mintotalcost = Long.MAX_VALUE;
        // Iterate through all possible center elements V[j] (0-indexed)
        for (int j = 0; j < N; j++) {
            long curr;
            // Case 1: j is Even (0, 2, 4, ...). No crossover needed across the gap.
            if (j % 2 == 0) {
                if (j == 0) {
                    curr = S[N - 1];
                }
                else if (j == N - 1) {
                    curr = P[N - 1];
                }
                else {
                    long prefix_cost = P[j];
                    long suffix_cost = S[N - j - 1];
                    curr = prefix_cost + suffix_cost;
                }
            }
            // Case 2: j is  Crossover pair (V[j-1], V[j+1]) is required.
            else {
                // Cost of paired prefix: V[0]...V[j-2]. Length j-1 (even).
                long pc = (j - 1 >= 2) ? P[j - 1] : 0;

                // Cost of paired suffix: V[j+2]...V[N-1]. Length N-j-2 (even).
                long sc = (N - j - 2 >= 2) ? S[N - j - 2] : 0;

                // Crossover pair cost: (V[j+1] - V[j-1]) / K
                long cc = (V.get(j + 1) - V.get(j - 1)) / K;

                curr = pc + cc + sc;
            }
            mintotalcost = Math.min(mintotalcost, curr);
        }

        return mintotalcost;
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
